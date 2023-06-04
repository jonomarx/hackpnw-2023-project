package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import core.Main;
import core.Renderable;

public class Tile implements Renderable {
	private int x;
	private int y;
	private int content = -1; // an ID of whats on it, eg: -1 is nothing
	private int[] contents = {-1};
	private int tick = 0;
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
		this.contents = new int[] {id};
	}
	
	public void setContents(int[] ids) {
		this.contents = ids;
	}
	
	public int getContent() {
		return content;
	}
	
	public int[] getContents() {
		return contents;
	}


	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		content = contents[(tick/6)%contents.length];
		if(content < 0) return;
		int xx = (int)Math.round(x*Main.SCALE+yoffset); // it just works.
		int yy = (int)Math.round(y*Main.SCALE+xoffset);
		g.drawImage(GameSim.getSpriteSheet().getImage(content), xx, yy, Main.SCALE, Main.SCALE, null);
		tick++;
	}

}
