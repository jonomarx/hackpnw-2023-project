package game;

import java.io.IOException;

import core.Main;
import core.RenderLayer;

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
		RenderLayer layer = new RenderLayer("tiles");
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = new Tile(i,j);
				layer.addObject(tiles[i][j]);
			}
		}
		Main.addRenderLayer(layer);
	}
	
	public static void update() {
		
	}
	
	public static SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
	
	public static boolean checkIfOccupied(int x, int y) {
		return tiles[x][y].getContent() < 0;
	}
	
	public static Tile[][] getTiles() {
		return tiles;
	}
	
	public boolean placeBuilding(String type) {
		
	}
}
