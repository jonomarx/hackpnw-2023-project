package game;
<<<<<<< HEAD
import java.util.ArrayList;
=======

import java.util.ArrayList;

>>>>>>> df4fb00fcc94468951d261f940012fe2d019ceeb
public class Building {
	public static void Main(String[] args) {
		Tile t = new Tile(10,10);
		ArrayList<Tile> test = new ArrayList<Tile>();
		test.add(t);
		Building b = new Building(test,10,10,"testBuilding",10,10);
		System.out.println(b.tilesOccupied().get(0));
		System.out.println(b.price());
		System.out.println(b.cashFlow());
		System.out.println(b.name());
		System.out.println(b.pollution());
		System.out.println(b.cashFlow());
	}
	//tile list
	//set tile to somthing
	private ArrayList<Tile> tilesOccupied;
	private int price;
	private int cashFlow;
	private String name;
	private int pollution;
	private int powerflow;
	public Building(ArrayList<Tile> tilesOccupiedIn, int priceIn, int cashFlowIn,
					String nameIn, int pollutionIn, int powerflowIn) {
		tilesOccupied = tilesOccupiedIn;
		price = priceIn;
		cashFlow = cashFlowIn;
		name = nameIn;
		pollution = pollutionIn;
		powerflow = powerflowIn;
		for(Tile t : tilesOccupied) {
			t.addBuilding(this);
		}

	}

	public ArrayList<Tile> tilesOccupied() {
		return tilesOccupied;
	}

	public int price() {
		return price;
	}
	public int cashFlow() {
		return cashFlow;
	}

	public String name() {
		return name;
	}
	public int pollution() {
		return pollution;
	}
	public int powerflow() {
		return powerflow;
	}
}
