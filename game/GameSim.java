package game;

public class GameSim {
	private final int tileWidth = 100;
	private final int tileHeight = 100;
	Tile[][] tiles = new Tile[tileWidth][tileHeight];
	
	private static double emissions = 0;
	private static double money = 20000;
	private static int tick = 0;
	private static double budget = 0;
	private static SpriteSheet spriteSheet;
	// statuses of the stuff -Tien
	
	public static void init() {
		
	}
	
	public static void update() {
		
	}
	
	public static SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
}
