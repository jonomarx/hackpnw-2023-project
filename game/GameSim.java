package game;

import java.io.IOException;
import java.util.HashMap;

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
	
	public static HashMap<String,BuildingInfo> buildings = new HashMap<>();
	static {
		buildings.put("Coal", new BuildingInfo("Coal", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Nuclear", new BuildingInfo("Nuclear", 100, -50, 0, 532, 6, 6, new int[] {1,1}));
		//buildings.add("Natural gas", new BuildingInfo("Natural gas", 100, -50, 2, 500, 1, 1, new int[] {1,1}));
		//buildings.add("Wind", new BuildingInfo("Wind", 100, -50, 0, 40, 18, 18, new int[] {1,1}));
		//buildings.add("Solar", new BuildingInfo("Solar", 100, -50, 0, 19, 1, 1, new int[] {1,1}));
		//buildings.add("Residential", new BuildingInfo("Residential", 100, -50, 0, 1, 1, 1, new int[] {1,1}));
		//buildings.add("Office", new BuildingInfo("Office", 100, -50, 0, 1, 1, 1, new int[] {1,1}));
		
	}
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
		return false;
	}
}
