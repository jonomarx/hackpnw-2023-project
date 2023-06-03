package game;
import java.util.*;
public class PowerPlant extends Building {
	private int generate;
	
	// maybe put in x, y later
	public PowerPlant(ArrayList<Tile> occupied, int cost, int cashflow, String type, int pollution, int powerflow) {
		// Use building class and put in the coordinates. 
		super(occupied, cost, cashflow, type, pollution, powerflow);
	}
}
