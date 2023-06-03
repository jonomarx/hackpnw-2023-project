package game;

import java.awt.Graphics;

import core.Renderable;

public class Tile implements Renderable {
	private int x;
	private int y;
	private int content; // an ID of whats on it, eg: 0 is 
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

	@Override
	public void render(Graphics g, int xoffset, int yoffset) {
		// TODO Auto-generated method stub
	}

}
