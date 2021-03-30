package com.shu.nitin.threads;

public class HoliGame {
	/**
	 * 
	 * class PlayGame { private Player p1;
	 * 
	 * private Player p2;
	 * 
	 * private Tools tool;
	 * 
	 * ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(); ReadLock readLock
	 * = rwl.readLock(); WriteLock writeLock = rwl.writeLock();
	 * 
	 * public PlayGame(Player p1, Player p2, Tools tool) { super(); this.p1 = p1;
	 * this.p2 = p2; this.tool = tool; }
	 * 
	 * boolean play() { boolean success = false; if (writeLock.tryLock()) { if
	 * (this.p1.getTools().contains(tool) && this.p2.gethCash() > tool.gethCash() &&
	 * this.p1 != this.p2) { System.out.println( "Player: " + this.p2.getPlayerId()
	 * + " hit by player: " + this.p1.getPlayerId() + " with " + tool);
	 * this.p1.sethCash(this.p2.gethCash() + tool.gethCash());
	 * this.p2.sethCash(this.p2.gethCash() - tool.gethCash());
	 * this.p1.getTools().remove(tool);
	 * 
	 * } } return success; }
	 * 
	 * }
	 * 
	 * private static final Random random = new Random();
	 * 
	 * boolean play(Player from, Player to, Tools tool) { return new PlayGame(from,
	 * to, tool).play(); }
	 * 
	 * public static void main(String[] args) throws InterruptedException {
	 * 
	 * List<Player> players = new ArrayList<>();
	 * 
	 * Thread initPlayers = new Thread(() -> { int playerId = 1; while
	 * (players.size() < 2) { players.add(new Player(playerId)); playerId++; } });
	 * 
	 * Thread game = new Thread(() -> { while (!players.isEmpty()) { int
	 * player1Index = random.nextInt(players.size()); int player2Index =
	 * random.nextInt(players.size()); if (player1Index != player2Index) { HoliGame
	 * holiGame = new HoliGame(); Player p1 = players.get(player1Index); Player p2 =
	 * players.get(player2Index); Optional<Tools> optTool =
	 * p1.getTools().stream().findFirst(); if (optTool.isPresent()) {
	 * holiGame.play(p1, p2, optTool.get()); } } } });
	 * 
	 * Thread printBalance = new Thread(() -> { while (!players.isEmpty()) { for
	 * (Player p : players) { System.out.println("Player Id: " + p.getPlayerId() +
	 * ", Hcash: " + p.gethCash()); } try { Thread.sleep(10000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } });
	 * 
	 * Thread removeZeroBalancePlayers = new Thread(() -> { while
	 * (!players.isEmpty()) { System.out.println("Removing 0 balance players"); for
	 * (Player p : players) { if (p.gethCash() <= 0) { System.out.println("Removed
	 * player: " + p.toString()); players.remove(p); } } try { Thread.sleep(10000);
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } });
	 * 
	 * Thread assignRandomTools = new Thread(() -> { while (!players.isEmpty()) {
	 * System.out.println("Adding random tools to player: "); for (Player p :
	 * players) { Optional<Tools> optTool = p.getTools().stream().findFirst(); if
	 * (!optTool.isPresent()) { p.getTools().addAll(Tools.TOOLS); } } try {
	 * Thread.sleep(20000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * });
	 * 
	 * initPlayers.start(); initPlayers.join(); game.start(); printBalance.start();
	 * removeZeroBalancePlayers.start(); assignRandomTools.start(); }
	 * 
	 * static class Player { private int playerId; private int hCash; private
	 * List<Tools> tools;
	 * 
	 * public Player(int playerId) { this.playerId = playerId; this.hCash = 50;
	 * this.tools = Tools.TOOLS; }
	 * 
	 * public int getPlayerId() { return playerId; }
	 * 
	 * public int gethCash() { return hCash; }
	 * 
	 * public void removeTool(Tools tool) { this.tools.remove(tool); }
	 * 
	 * public List<Tools> getTools() { return Collections.unmodifiableList(tools); }
	 * 
	 * public void sethCash(int hCash) { this.hCash = hCash; } }
	 * 
	 * enum Tools { BALOON(5), PICHKARI(10), GULAL(20), MATCHBOX(50);
	 * 
	 * private int hCash;
	 * 
	 * private static final List<Tools> TOOLS = new LinkedList<>(
	 * Arrays.asList(Tools.BALOON, Tools.PICHKARI, Tools.GULAL, Tools.MATCHBOX));
	 * 
	 * Tools(int hCash) { this.hCash = hCash; }
	 * 
	 * public int gethCash() { return hCash; } }
	 **/
}
