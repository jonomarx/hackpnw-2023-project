package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import core.Main;
import core.Renderable;

public class DateAndTimeMeter implements Renderable {
	private String text = "Date and Time";
	
	public DateAndTimeMeter() {
		
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0, (int) (Main.WIDTH/2.5)+20, 50);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (int) (Main.WIDTH/2.5)+20, 50);
		g.drawRect(1, 1, (int) (Main.WIDTH/2.5)+20-1, 50-1);
		g.drawRect(2, 2, (int) (Main.WIDTH/2.5)+20-2, 50-2);
		g.setFont(new Font("Sans", Font.PLAIN, 18));
		g.drawString(text, 10, 30);
	}

}
