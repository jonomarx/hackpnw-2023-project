package game;
import java.util.*;
public class Coal extends PowerPlant {
	private final int WIDTH = 1;
	private final int LENGTH = 1;
	private final int pollution = 20;
	private final int cost = 100;
	private final int x;
	private final int y;
	private final int cashflow = -50;
	
	//coal constructor
	public Coal (int posx, int posy, int cost, int pollution) {
		super(posx, posy, 1, 1, 100, -50, "Coal", 20, 100);
		// Check to see if the tile is aviliable.
		x=posx;
		y=posy;
		
	}
}
