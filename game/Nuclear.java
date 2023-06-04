package game;
import java.util.*;
public class Nuclear extends PowerPlant{
	private static int WIDTH = 1;
	private static int LENGTH = 1;
	private static int pollution = 20;
	private static int cost = 100;
	private static int x;
	private static int y;
	private static int cashflow = -80;

	//coal constructor
	public Nuclear (int posx, int posy, int cost, int pollution) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Nuclear", pollution, 100);
		
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}	
}
