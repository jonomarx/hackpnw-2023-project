package game;

import java.awt.Color;
import java.awt.Graphics;

import core.Renderable;

public class Selector implements Renderable {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color = null;
	
	private int selX;
	private int selY;
	
	public Selector() {
		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		if(color == null) return;
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
