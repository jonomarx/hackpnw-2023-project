package game;
import java.util.*;
public class Solar extends PowerPlant{
	private final int WIDTH = 1;
	private final int LENGTH = 1;
	private final int pollution = 0;
	private final int cost = 50;
	private final int x;
	private final int y;
	private final int cashflow = -3;
	//coal constructor
	public Solar (int posx, int posy, int cost, int pollution) {
		super(posx, posy, 1, 1, 50, 0, "Solar", 0, 100);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}	
}