package game;

public class Consumer extends Building {
	public Consumer(int xIn, int yIn, int widthIn, int heightIn, int priceIn, int cashFlowIn, String nameIn,
			int pollutionIn, int powerflowIn, int idIn) {
		super(xIn, yIn, widthIn, heightIn, priceIn, cashFlowIn, nameIn, pollutionIn, powerflowIn, idIn);
		// TODO Auto-generated constructor stub
	}
	public Consumer(int x, int y, int width, int height, int cost, int cashflow, String type, int pollution, int powerflow, int id, int[][][] anim) {
		// Use building class and put in the coordinates. 
		super(x, y, width, height, cost, cashflow, type, pollution, powerflow, id, anim);
		
	}
}
