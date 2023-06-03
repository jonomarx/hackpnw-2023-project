package game;

import java.awt.Graphics;

import core.Main;
import core.Renderable;

public class Tile implements Renderable {
	private int x;
	private int y;
	private int content; // an ID of whats on it, eg: -1 is nothing
	private Building localBuilding;
	private boolean occupied = false;
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setContent(int id) {
		this.content = id;
	}
	
	public int getContent(int id) {
		return content;
	}

	public boolean isOccupied() {
		return occupied;
	}
	public boolean addBuilding(Building b) {
		if(!occupied) {
			localBuilding = b;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		g.drawImage(GameSim.getSpriteSheet().getImage(content), (int)Math.round(x*Main.SCALE+xoffset), (int)Math.round(y*Main.SCALE+yoffset), null);
	}

}
