package com.shu.nitin.passbyvalue;

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

public class HoliGameFinal2 {

	private static final Random random = new Random();

	public static void main(String[] args) throws InterruptedException {

		List<Player> players = new ArrayList<>();

		Thread initPlayers = new Thread(() -> {
			int playerId = 1;
			while (players.size() < 20) {
				players.add(new Player(playerId));
				playerId++;
			}
		});
		initPlayers.start();
		initPlayers.join();

		Game game = Game.init(players);

		Thread playGame = new Thread(() -> {
			List<Player> activePlayers = game.getPlayers();
			while (!activePlayers.isEmpty()) {
				int p1Id = random.nextInt(players.size());
				int p2Id = random.nextInt(players.size());
				if (p1Id != p2Id) {
					Player p1 = activePlayers.get(p1Id);
					Player p2 = activePlayers.get(p2Id);
					Optional<Tools> optTool = p1.getTools().stream().findFirst();
					if (optTool.isPresent()) {
						game.play(p1, p2, optTool.get());
					}
				}
			}
		});

		Thread printBalance = new Thread(() -> {
			List<Player> activePlayers = game.getPlayers();
			while (!activePlayers.isEmpty()) {
				for (Player p : activePlayers) {
					System.out.print("| " + p.getPlayerId() + " - " + p.gethCash() + " ");
				}
				System.out.println("|");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		playGame.start();
		printBalance.start();

	}
}

class PlayGame {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();

	public void play(Player p1, Player p2, Tools tool) {
		try {
			if (writeLock.tryLock()) {
				if (p1.getTools().contains(tool) && p2.gethCash() > tool.gethCash() && p1 != p2) {
					System.out.println(
							"Player: " + p2.getPlayerId() + " hit by player: " + p1.getPlayerId() + " with " + tool);
					p1.sethCash(p1.gethCash() + tool.gethCash());
					p2.sethCash(p2.gethCash() - tool.gethCash());
					p1.getTools().remove(tool);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		} finally {
			writeLock.unlock();
		}

	}

}

class Game {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private WriteLock writeLock = lock.writeLock();
	private ReadLock readLock = lock.readLock();

	private PlayGame play;

	private List<Player> players;

	private static Game game;

	private Game(List<Player> players) {
		super();
		this.players = new LinkedList<>(players);
		this.play = new PlayGame();
	}

	public static Game init(List<Player> players) {
		if (null == game) {
			game = new Game(players);
		}
		return game;
	}

	public void play(Player p1, Player p2, Tools tool) {
		play.play(p1, p2, tool);
	}

	public void addPlayer(Player player) {
		try {
			if (writeLock.tryLock()) {
				players.add(player);
			}
		} finally {
			writeLock.unlock();
		}

	}

	public void removePlayer(Player player) {
		try {
			if (writeLock.tryLock()) {
				players.remove(player);
			}
		} finally {
			writeLock.unlock();
		}
	}

	public List<Player> getPlayers() {
		try {
			if (readLock.tryLock()) {
				return Collections.unmodifiableList(this.players);
			}
		} finally {
			readLock.unlock();
		}
		return Collections.emptyList();

	}

}

class Player {

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
		return hCash;
	}

	public List<Tools> getTools() {
		return tools;
	}

	public void sethCash(int hCash) {
		this.hCash = hCash;
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
