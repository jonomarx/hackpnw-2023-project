package game;
import java.util.*;
public class Oil extends PowerPlant {
	private final int WIDTH = 1;
	private final int LENGTH = 1;
	private final int pollution = 15;
	private final int cost = 60;
	private final int x;
	private final int y;
	private final int cashflow = -20;
	
	//coal constructor
	public Oil (int posx, int posy, int cost, int pollution) {
		super(posx, posy, 1, 1, 60, -20, "Oil", 15, 75);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}