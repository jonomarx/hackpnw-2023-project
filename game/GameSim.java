package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import core.Main;
import core.RenderLayer;

public class GameSim {
	private static final int tileWidth = 4;
	private static final int tileHeight = 4;
	private static final Tile[][] tiles = new Tile[tileWidth][tileHeight];
	
	private static double emissions = 0;
	private static double money = 20000;
	private static int tick = 0;
	private static double budget = 0;
	private static SpriteSheet spriteSheet;
	
	private static ArrayList<Consumer> activeConsumers;
	private static ArrayList<PowerPlant> activePowerPlants;
	
	public static HashMap<String,BuildingInfo> buildings = new HashMap<>();
	static {
		buildings.put("Coal", new BuildingInfo("Coal", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Nuclear", new BuildingInfo("Nuclear", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Oil", new BuildingInfo("Oil", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Wind", new BuildingInfo("Wind", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Solar", new BuildingInfo("Solar", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Residential", new BuildingInfo("Residential", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Office", new BuildingInfo("Office", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
		//buildings.add("Industry", new BuildingInfo("Industry", 100, -50, 20, 100, 1, 1, new int[] {1,1}));
	}
	// statuses of the stuff -Tien
	
	public static void init() throws IOException {
		spriteSheet = new SpriteSheet("/res/testsheet.png", 4);
		RenderLayer layer = new RenderLayer("tiles");
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				tiles[i][j] = new Tile(i,j);
				layer.addObject(tiles[i][j]);
			}
		}
		Main.addRenderLayer(layer);
	}
	
	public static void update() {
		double energyTotal = 0;
		double income = 0;
		for(Consumer c : activeConsumers) {
			energyTotal += c.powerflow();
			emissions += c.pollution();
			income += c.cashFlow();
		}
		// energy priority: nuclear+coal, wind+solar, gas
		
		// optional: batteries
		double baselinePower = 0;
		double renewablePower = 0;
		double gasPowerCapacity = 0;
		double gasEmissions = 0;
		double gasPrice = 0;
		double expenses = 0;
		for(PowerPlant p : activePowerPlants) {
			switch(p.name()) {
				case "Coal":
					baselinePower += p.powerflow();
					expenses -= p.cashFlow();
					emissions += p.pollution();
					break;
				case "Nuclear":
					baselinePower += p.powerflow();
					expenses -= p.cashFlow();
					emissions += p.pollution();
					break;
				case "Wind":
					renewablePower += p.powerflow();
					expenses -= p.cashFlow(); // should be 0 usually
					emissions += p.pollution(); // should be 0 usually
					break;
				case "Solar":
					renewablePower += p.powerflow();
					expenses -= p.cashFlow(); // should be 0 usually
					emissions += p.pollution(); // should be 0 usually
					break;
				case "Oil":
					gasPowerCapacity += p.powerflow();
					gasPrice -= p.cashFlow(); // gas price is the cost of the all the gas
					gasEmissions += p.pollution(); // total emissions assuming full power
					break;
			}
		}
		double powerNeeds = energyTotal;
		double pWithoutPower = 0;
		energyTotal -= baselinePower;
		energyTotal -= renewablePower;
		if(energyTotal > 0) {
			double pOfGasRequired = energyTotal/gasPowerCapacity;
			if(pOfGasRequired >= 1) {
				double amountOver = gasPowerCapacity * (1-pOfGasRequired);
				pWithoutPower = amountOver/powerNeeds;
				pOfGasRequired = 1;
			} else {
				energyTotal = 0;
				pWithoutPower = 0;
			}
			double gasCost = pOfGasRequired * gasPrice;
			expenses += gasCost;
			emissions += pOfGasRequired * gasEmissions;
		}
		double moneys = income - expenses;
	}
	
	public static SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
	
	public static boolean checkIfOccupied(int x, int y) {
		return tiles[x][y].getContent() < 0;
	}
	
	public static Tile[][] getTiles() {
		return tiles;
	}
	
	public boolean placeBuilding(String type) {
		return false;
	}
}
