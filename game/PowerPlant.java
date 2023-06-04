package game;
import java.util.*;

public class PowerPlant extends Building {
	
	// maybe put in x, y later
	public PowerPlant(int x, int y, int width, int height, int cost, int cashflow, String type, int pollution, int powerflow, int id) {
		// Use building class and put in the coordinates. 
		super(x, y, width, height, cost, cashflow, type, pollution, powerflow, id);
		
	}
	public PowerPlant(int x, int y, int width, int height, int cost, int cashflow, String type, int pollution, int powerflow, int id, int[][][] anim) {
		// Use building class and put in the coordinates. 
		super(x, y, width, height, cost, cashflow, type, pollution, powerflow, id, anim);
		
	}
}
