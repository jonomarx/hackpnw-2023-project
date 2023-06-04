package game;
import java.util.*;
public class Nuclear extends PowerPlant{
	private final int WIDTH = 1;
	private final int LENGTH = 1;
	private final int pollution = 0;
	private final int cost = 100;
	private final int x;
	private final int y;
	private final int cashflow = -80;
	//coal constructor
<<<<<<< HEAD
	public Nuclear (int posx, int posy) {
		super(posx, posy, 1, 1, 100, -50, "Nuclear", 0, 100);
=======
	public Nuclear (int posx, int posy, int cost, int pollution) {
		super(posx, posy, WIDTH, LENGTH, cost, cashflow, "Nuclear", pollution, 100, 2);
		
>>>>>>> 5d9694746f630542605f1c8e99784564a071cf04
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}	
}
