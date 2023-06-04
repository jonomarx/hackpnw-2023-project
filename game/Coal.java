package game;
import java.util.*;
public class Coal extends PowerPlant {
	private static int WIDTH = 2;
	private static int LENGTH = 2;
	private static int pollution = 20;
	private static int cost = 100;
	private static int x;
	private static int y;
	private static int cashflow = -50;
	
	private static int[][][] animTable = new int[][][] {
		{{3,7,11,15}, {5,9,13,17}},
		{{4,8,12,16}, {6,10,14,18}}
	};
	
	//coal constructor
	public Coal (int posx, int posy) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Coal", pollution, 100, 1, animTable);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}
