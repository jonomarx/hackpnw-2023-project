package game;

import java.io.IOException;

public class GameSim {
	private static final int tileWidth = 4;
	private static final int tileHeight = 4;
	private static final Tile[][] tiles = new Tile[tileWidth][tileHeight];
	
	private static double emissions = 0;
	private static double money = 20000;
	private static int tick = 0;
	private static double budget = 0;
	private static SpriteSheet spriteSheet;
	// statuses of the stuff -Tien
	
	public static void init() throws IOException {
		spriteSheet = new SpriteSheet("/res/testsheet.png", 4);
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = new Tile(i,j);
			}
		}
		
		tiles[0][0].setContent(0);
		tiles[0][1].setContent(1);
		tiles[1][0].setContent(2);
		tiles[1][1].setContent(3);
	}
	
	public static void update() {
		
	}
	
	public static SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
	
	public boolean checkIfOccupied(int x, int y) {
		return tiles[x][y].getContent() < 0;
	}
}
