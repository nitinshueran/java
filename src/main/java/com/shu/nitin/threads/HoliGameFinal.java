package com.shu.nitin.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class HoliGameFinal {

	private static final Random random = new Random();

	public static void main(String[] args) throws InterruptedException {

		List<Player> players = new ArrayList<>();

		int playerId = 1;
		while (players.size() < 5) {
			players.add(new Player(playerId));
			playerId++;
		}

		Game game = new Game(players);
		List<Thread> active = new ArrayList<>();
		List<Player> activePlayers = game.getPlayers();
		int i = 0;
		while (i < 15) {
			i++;
			int p1Id = random.nextInt(players.size());
			int p2Id = random.nextInt(players.size());
			if (p1Id != p2Id) {
				Player p1 = activePlayers.get(p1Id);
				Player p2 = activePlayers.get(p2Id);
				Optional<Tools> optTool = p1.getTools().stream().findFirst();
				if (optTool.isPresent()) {
					active.add(new Thread(() -> {
						game.play(p1, p2, optTool.get());
					}));
				}
			}
		}

		Thread printPlayerStatus = new Thread(() -> {
			while (!activePlayers.isEmpty()) {
				int sum = activePlayers.stream().mapToInt(Player::gethCash).sum();

				for (Player player : activePlayers) {
					System.out.print("| " + player.getPlayerId() + " - " + player.gethCash()
							+ " ");
				}
				System.out.print("Sum: " + sum + " |");
				System.out.println();
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		printPlayerStatus.start();
		for (Thread t : active) {
			t.start();
		}
		Thread.sleep(5000);
		for (Player player : game.getPlayers()) {
			System.out.print("Final: | " + player.getPlayerId() + " - " + player.gethCash() + " ");
		}
	}
}

class Game {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();
	private ReadLock readLock = lock.readLock();

	private List<Player> players;

	public Game(List<Player> players) {
		super();
		this.players = new LinkedList<>(players);
	}

	public void play(Player p1, Player p2, Tools tool) {

		if (p1.getTools().contains(tool) && p2.gethCash() >= tool.gethCash() && p1 != p2) {
			System.out.println("Player: " + p2.getPlayerId() + " hit by player: " + p1.getPlayerId() + " with " + tool);
			p1.sethCash(p1.gethCash() + tool.gethCash());
			p2.sethCash(p2.gethCash() - tool.gethCash());
			p1.removeTool(tool);

		}

	}

	public void addPlayer(Player player) {
		try {
			writeLock.lock();
			players.add(player);
		} finally {
			writeLock.unlock();

		}

	}

	public void removePlayer(Player player) {
		try {
			writeLock.lock();
			players.remove(player);
		} finally {
			writeLock.unlock();
		}
	}

	public List<Player> getPlayers() {
		try {
			readLock.lock();
			return Collections.unmodifiableList(this.players);
		} finally {
			readLock.unlock();
		}

	}

}

class Player {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock readLock = lock.readLock();
	private WriteLock writeLock = lock.writeLock();

	private int playerId;
	private int hCash;
	private List<Tools> tools;

	public Player(int playerId) {
		this.playerId = playerId;
		this.hCash = 50;
		this.tools = new LinkedList<>(Arrays.asList(Tools.BALOON, Tools.PICHKARI, Tools.GULAL, Tools.MATCHBOX));
	}

	public int getPlayerId() {
		return playerId;
	}

	public int gethCash() {
		try {
			readLock.lock();
			return this.hCash;
		} finally {
			readLock.unlock();
		}
	}

	public List<Tools> getTools() {
		try {
			readLock.lock();
			return tools;
		} finally {
			readLock.unlock();
		}
	}

	public boolean removeTool(Tools tool) {
		try {
			writeLock.lock();
			return getTools().remove(tool);
		} finally {
			writeLock.unlock();
		}
	}

	public void sethCash(int hCash) {
		try {
			writeLock.lock();
			this.hCash = hCash;
		} finally {
			writeLock.unlock();
		}
	}

}

enum Tools {
	BALOON(5), PICHKARI(10), GULAL(20), MATCHBOX(50);

	private int toolHcashValue;

	Tools(int hCash) {
		this.toolHcashValue = hCash;
	}

	public int gethCash() {
		return toolHcashValue;
	}
}
