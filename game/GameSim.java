package game;
import java.io.File;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import core.Main;
import core.RenderLayer;

public class GameSim {
	private static int tileWidth;
	private static int tileHeight;
	private static Tile[][] tiles;
	
	private static double emissions = 0;
	private static double money = 20000;
	private static int tick = 0;
	private static double budget = 0;
	private static SpriteSheet spriteSheet;
	
	private static HappinessMeter hp;
	private static double happiness = 100;
	private static GregorianCalendar cal;
	private static DateAndTimeMeter dateMeter = new DateAndTimeMeter();
	private static MoneyMeter moneyMeter = new MoneyMeter();
	private static Selector selector = new Selector();
	private static BuildingInfo attemptBuildBuilding = null;
	private static int attemptx = 5*Main.SCALE;
	private static int attempty = 5*Main.SCALE;
	private static int selectState = 0; // select state, 0: none, 1: build, 2: delete
	private static double energyPrice=5;//dummy val
	private static ArrayList<Consumer> activeConsumers = new ArrayList<>();
	private static ArrayList<PowerPlant> activePowerPlants = new ArrayList<>();
	
	public static HashMap<String,BuildingInfo> buildings = new HashMap<>();
	static {
		//                                       name,price,
		                                               // cashflow,
		                                                      //polution,
		                                                            //powerflow
		                                                           //    width heihgt
		buildings.put("Coal", new BuildingInfo("Coal", 100, -50, 1.7, 100, 2, 2, new int[] {1,1}));
		buildings.put("Nuclear", new BuildingInfo("Nuclear", 100, -50, 0, 532, 9, 4, new int[] {1,1}));
		buildings.put("Natural Gas", new BuildingInfo("Natural Gas", 100, -50, 2, 1725, 1, 1, new int[] {1,1}));
		buildings.put("Wind", new BuildingInfo("Wind", 100, -50, 0, 40, 19, 19, new int[] {1,1}));
		buildings.put("Solar", new BuildingInfo("Solar", 100, -50, 0, 19, 1, 1, new int[] {1,1}));
		buildings.put("Residental", new BuildingInfo("Residental", 100, -50, 0, -33.6473755047, 4, 4, new int[] {1,1}));
		buildings.put("Office", new BuildingInfo("Office", 100, -50, 0, -20.5479452055, 2, 2, new int[] {1,1}));
		buildings.put("Road", new BuildingInfo("Road", 100, -50, 0, 0, 1, 1, new int[] {1,1}));
	}
	// statuses of the stuff -Tien
	
	public static void init() throws IOException {
		spriteSheet = new SpriteSheet("/res/finalSpritesheet.png", 50);
		initTiles("/res/Starting-Map.png");
		RenderLayer layer = new RenderLayer("tiles");
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				layer.addObject(tiles[i][j]);
			}
		}
		Main.addRenderLayer(layer);
		
		hp = new HappinessMeter();
		RenderLayer layer2 = new RenderLayer("ui");
		cal = new GregorianCalendar(2000, 1, 1, 0, 0);
		dateMeter.setText(Month.of(cal.get(GregorianCalendar.MONTH)).name() + " " + cal.get(GregorianCalendar.DAY_OF_MONTH) + ", " + cal.get(GregorianCalendar.YEAR) + " " + cal.get(GregorianCalendar.HOUR) + ":00");
		moneyMeter = new MoneyMeter();
		moneyMeter.setMoney(money);
		selector.setX(250);
		selector.setY(250);
		selector.setWidth(Main.SCALE);
		selector.setHeight(Main.SCALE);
		selector.setColor(Color.GREEN);
		layer2.addObject(hp);
		layer2.addObject(dateMeter);
		layer2.addObject(moneyMeter);
		layer2.addObject(selector);
		Main.addRenderLayer(layer2);
	}
	
	public static void update() {
		
		//emmisions per tick
		
		double energyTotal = 0;
		double income = 0;
		for(Consumer c : activeConsumers) {
			energyTotal += buildings.get(c.name()).powerflow;
			emissions += buildings.get(c.name()).pollution;
		}
		// energy priority: nuclear+coal, wind+solar, gas
		
		// optional: batteries
		double baselinePower = 0;
		double renewablePower = 0;
		double gasPowerCapacity = 0;
		double gasEmissions = 0;
		double gasPrice = 0;
		double expenses = 0;
		for(PowerPlant pp : activePowerPlants) {
			pp.update(tick);
			BuildingInfo p = buildings.get(pp.name());
			switch(p.name) {
				case "Coal":
					baselinePower += p.powerflow;
					expenses -= p.cashFlow;
					emissions += p.pollution;
					break;
				case "Nuclear":
					baselinePower += p.powerflow;
					expenses -= p.cashFlow;
					emissions += p.pollution;
					break;
				case "Wind":
					renewablePower += p.powerflow;
					expenses -= p.cashFlow; // should be 0 usually
					emissions += p.pollution; // should be 0 usually
					break;
				case "Solar":
					renewablePower += p.powerflow;
					expenses -= p.cashFlow; // should be 0 usually
					emissions += p.pollution; // should be 0 usually
					break;
				case "Oil":
					gasPowerCapacity += p.powerflow;
					gasPrice -= p.cashFlow; // gas price is the cost of the all the gas
					gasEmissions += p.pollution; // total emissions assuming full power
					break;
			}
		}
		double powerNeeds = energyTotal;
		powerNeeds = Math.abs(energyTotal);
		energyTotal =Math.abs(energyTotal);
		double pWithoutPower = 0;
		double energyProduction = baselinePower + renewablePower;
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
			energyProduction += pOfGasRequired * gasPowerCapacity;
		}
		//energyprice is a dummy val
		energyTotal = Math.max(0,energyTotal);
		income = energyPrice*powerNeeds - energyPrice*energyTotal;
		System.out.println("Income: " + income + "PowerNeeds: " + powerNeeds + "EnergyTotal: " + energyTotal);
		double moneys = income - expenses;
		money += moneys;
		
		switch(selectState) {
			case 1:
				selector.setX(attemptx);
				selector.setY(attempty);
				selector.setWidth(attemptBuildBuilding.width*Main.SCALE);
				selector.setHeight(attemptBuildBuilding.height*Main.SCALE);
				selector.setColor(placeBuilding(selector.getX()/Main.SCALE, selector.getY()/Main.SCALE, attemptBuildBuilding.width, attemptBuildBuilding.height) ? Color.GREEN : Color.RED);
				//System.out.println(selector.getX()/30 + " " + selector.getY()/30);
				//System.out.println(selector.getX()/Main.SCALE + selector.getY()/Main.SCALE);
				break;
			case 2:
				selector.setX(5*Main.SCALE);
				selector.setY(5*Main.SCALE);
				selector.setWidth(Main.SCALE);
				selector.setHeight(Main.SCALE);
				selector.setColor(Color.RED);
		}
		attemptBuildBuilding = buildings.get("Nuclear");
		selectState = 1;
		
		happiness -= 0.5;
		hp.setHappiness(happiness);
		cal.add(GregorianCalendar.HOUR, 4);
		dateMeter.setText(Month.of(cal.get(GregorianCalendar.MONTH)).name() + " " + cal.get(GregorianCalendar.DAY_OF_MONTH) + ", " + cal.get(GregorianCalendar.YEAR) + " " + cal.get(GregorianCalendar.HOUR_OF_DAY) + ":00");
		moneyMeter.setMoney(money);
		System.out.println("Energy needs: " + powerNeeds + " Energy production: " + energyProduction + " Percent without energy: " + pWithoutPower + " money: " + money);
		tick++;
	}
	private static Building getBuilding(int id, int x, int y) {
		switch(id) {
		case 1:
			return new Coal(x,y);
		
		case 2:
			return new Nuclear(x,y);
		case 3:
			//new name natural gas
			return new Oil(x,y);
		case 4:
			return new Wind(x,y);
		case 5:
			return new Solar(x,y);
		case 6:
			return new Residental(x,y);
		case 7:
			return new Office(x,y);
		case 8:
			return new Road(x,y,true);
		}
		return null;
	}
	private static void initTiles(String fileName) {
		try {
			
		      BufferedImage img = ImageIO.read(GameSim.class.getResourceAsStream(fileName));
		      tileWidth = img.getWidth();
		      tileHeight = img.getHeight();
		      tiles = new Tile[tileWidth][tileHeight];
		      for(int i = 0; i < img.getHeight(); i++) {
		    	  for(int j = 0; j < img.getWidth(); j++) {
		    		  tiles[i][j] = new Tile(i,j);
		    	  }
		      }
		      
		      for (int y = 0; y < img.getHeight(); y++) {
		         for (int x = 0; x < img.getWidth(); x++) {
		            //Retrieving contents of a pixel
		            int pixel = img.getRGB(x,y);
		            //Creating a Color object from pixel value
		            Color color = new Color(pixel, true);
		            //Retrieving the R G B values
		            int red = color.getRed();
		            int green = color.getGreen();
		            int blue = color.getBlue();
		            if(red==255&&green==0&&blue==0) {
		            	tiles[x][y].setContent(2);
		            }
		            else if(red==255&&green==255) {
		            	activeConsumers.add((Consumer)getBuilding(6,x,y));
		            }
		            else if(blue==255) {
		            	activePowerPlants.add((PowerPlant)getBuilding(1,x,y));
		            }
		         }
		      }
		}
		catch(Exception e) {
			
			e.printStackTrace();
			System.exit(10);
		}
	}
	private static boolean deconstructTile(Tile t) {
		boolean found=false;
		for(int k = 0; k < activeConsumers.size(); k++) {
			Consumer c = activeConsumers.get(k);
			for(int i = c.x(); i <c.x()+c.width(); i++) {
				for(int j = c.y(); j <c.y()+c.height(); j++) {
					
					if(i==t.getX()&&j==t.getY()) {
						c.deconstruct();
						return true;
					}
				}
			}
		}
		for(int k = 0; k < activePowerPlants.size(); k++) {
			PowerPlant p = activePowerPlants.get(k);
			for(int i = p.x(); i <p.x()+p.width(); i++) {
				for(int j = p.y(); j <p.y()+p.height(); j++) {
					
					if(i==t.getX()&&j==t.getY()) {
						p.deconstruct();
						return true;
					}
				}
			}
		}
		return false;
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
	
	public static boolean placeBuilding(int x, int y, int width, int height) {
		for(int i = x; i <x+width; i++) {
			for(int j = y; j <y+height; j++) {
				if(i >= tiles.length || i<0|| j >= tiles[0].length || j <0) {
					return false;
				}
				if(tiles[i][j].getContent() >= 0) {
					return false;
				}
			}
		}
		return true;
	}
}
