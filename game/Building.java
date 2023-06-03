package game;

public class Building {
	//tile list
	//set tile to somthing
	private ArrayList<Tiles> tilesOccupied;
	private int price;
	private int cashFlow;
	private String name;
	private int pollution;
	private int powerflow;
	private int id;
	public Building(ArrayList<Tiles> tilesOccupiedIn, int priceIn, int cashFlowIn, String nameIn, int pollutionIn, int powerflowIn) {
		price = priceIn;

	}
}
