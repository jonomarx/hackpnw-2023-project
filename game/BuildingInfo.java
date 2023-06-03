package game;

public class BuildingInfo {
	public String name;
	public double price;
	public double cashFlow;
	public double pollution;
	public double powerflow;
	public int width;
	public int height;
	public int[] ids;
	
	public BuildingInfo() {
		
	}
	
	public BuildingInfo(String name, double price, double cashFlow, double pollution, double powerflow, int width, int height, int[] ids) {
		this.name = name;
		this.price = price;
		this.cashFlow = cashFlow;
		this.pollution = pollution;
		this.powerflow = powerflow;
		this.width = width;
		this.height = height;
		this.ids = ids;
	}
}
