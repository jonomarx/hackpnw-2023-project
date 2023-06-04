package game;
import java.util.*;
public class Coal extends PowerPlant {
	private static int WIDTH = 1;
	private static int LENGTH = 1;
	private static int pollution = 20;
	private static int cost = 100;
	private static int x;
	private static int y;
	private static int cashflow = -50;
	
	//coal constructor
	public Coal (int posx, int posy) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Coal", pollution, 100);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}
