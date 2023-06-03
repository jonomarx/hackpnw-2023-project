package game;

public class GameSim {
	private final int tileWidth = 100;
	private final int tileHeight = 100;
	Tile[][] tiles = new Tile[tileWidth][tileHeight];
	
	private double emissions = 0;
	private double money = 20000;
	private int tick = 0;
	private double budget = 0;
	
	public GameSim() {
		
	}
}
