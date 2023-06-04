package game;
import java.util.*;
public class Oil extends PowerPlant {
	private static int WIDTH = 1;
	private static int LENGTH = 1;
	private static int pollution = 15;
	private static int cost = 60;
	private static int x;
	private static int y;
	private static int cashflow = -20;
	
	//coal constructor
	public Oil (int posx, int posy, int cost, int pollution) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Oil", pollution, 75);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}