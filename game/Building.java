package game;
import java.util.ArrayList;

public class Building {
	//tile list
	//set tile to somthing
	private ArrayList<Tile> tilesOccupied=new ArrayList<>();
	protected double price;
	protected double cashFlow;
	private String name;
	protected double pollution;
	protected double powerflow;
	private int x;
	private int y;
	private final int width;
	private final int height;
	public Building(int xIn, int yIn, int widthIn, int heightIn, int priceIn, int cashFlowIn,
					String nameIn, int pollutionIn, int powerflowIn) {
		x=xIn;
		y=yIn;
		width=widthIn;
		height=heightIn;
		price = priceIn;
		cashFlow = cashFlowIn;
		name = nameIn;
		pollution = pollutionIn;
		powerflow = powerflowIn;
		Tile[][] tiles = GameSim.getTiles();
		try {
		for(int i = x; i <x+width; i++) {
			for(int j = y; j <y+height; j++) {
				tilesOccupied.add(tiles[i][j]);
				tiles[i][j].setContent(1);
			}
		}
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Building index is out of bonds");
			System.exit(-1);
		}
	}
	public int x() {
	return x;
	}
	public int y(){
	return y;
	}
	public int width() {
	return width;
	}
	public int height() {
	return height;
	}
	
	public ArrayList<Tile> tilesOccupied() {
		return tilesOccupied;
	}

	public double price() {
		return price;
	}
	public double cashFlow() {
		return cashFlow;
	}

	public String name() {
		return name;
	}
	public double pollution() {
		return pollution;
	}
	public double powerflow() {
		return powerflow;
	}
	
	public void deconstruct() {
		Tile[][] tiles = GameSim.getTiles();
		for(int i = x; i <x+width; i++) {
			for(int j = y; j <y+height; j++) {
				tiles[i][j].setContent(-1);
			}
		}
		tilesOccupied.clear();
	}
	
	public void update(int tick) {
		
	}
}
