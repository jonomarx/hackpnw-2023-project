package game;

import java.awt.Color;
import java.awt.Graphics;

import core.Main;
import core.Renderable;

public class Tile implements Renderable {
	private int x;
	private int y;
	private int content = -1; // an ID of whats on it, eg: -1 is nothing
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
	
	public int getContent() {
		return content;
	}


	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		if(content < 0) return;
		int xx = (int)Math.round(x*Main.SCALE+xoffset);
		int yy = (int)Math.round(y*Main.SCALE+yoffset);
		g.drawImage(GameSim.getSpriteSheet().getImage(content), xx, yy, Main.SCALE, Main.SCALE, null);
		g.setColor(Color.BLACK);
	}

}
