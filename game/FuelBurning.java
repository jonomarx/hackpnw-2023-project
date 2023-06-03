package game;
import java.util.*;
public class FuelBurning extends PowerPlant {
	private final int WIDTH;
	private final int LENGTH;
	private final int POLLUTION; // Placebo constant
	private final int FLOW;
	private int cost;
	private int x;
	private int y;
	
	//coal constructor
	// cost is just initializing/setup cost flow is the daily cost of the power plant. 
	public FuelBurning (ArrayList<Tile> t, int posx, int posy, int cost, int pollution, int flow, String type, int powerflow) {
		super(t, cost, flow, type, pollution, powerflow);
		WIDTH = 1;
		LENGTH = 1;
		POLLUTION = 20; // Placebo constant
		FLOW = 3; // Placebo constant
		x = posx;
		y = posy;
		this.cost = cost;
		// Make a tile for the potential powerplant
		Tile tile = new Tile(posx, posy);
		
		
		
		
		
		
		
	}
}