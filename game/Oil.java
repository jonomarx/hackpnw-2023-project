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
<<<<<<< HEAD
	public Oil (int posx, int posy) {
		super(posx, posy, WIDTH, LENGTH, 60, cashflow, "Oil", 15, 75);
=======
	public Oil (int posx, int posy, int cost, int pollution) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Oil", pollution, 75, 3);
>>>>>>> 5d9694746f630542605f1c8e99784564a071cf04
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}