package game;
import java.util.*;
public class Solar extends PowerPlant{
	private static int WIDTH = 1;
	private static int LENGTH = 1;
	private static int pollution = 0;
	private static int cost = 50;
	private static int x;
	private static int y;
	private static int cashflow = -3;
	
	//coal constructor
	public Solar (int posx, int posy) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Solar", pollution, 100, 5);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}	
}