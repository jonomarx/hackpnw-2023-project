package game;

import java.awt.Graphics;

import core.Renderable;

public class Tile implements Renderable {
	private int x;
	private int y;
	private int content;
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
	
	public void setOccu

	@Override
	public void render(Graphics g, int xoffset, int yoffset) {
		// TODO Auto-generated method stub
	}

}
