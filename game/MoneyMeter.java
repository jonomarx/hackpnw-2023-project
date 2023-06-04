package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import core.Main;
import core.Renderable;

public class MoneyMeter implements Renderable {
	private double money = 0;
	
	public MoneyMeter() {
		
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		g.setColor(Color.WHITE);
		g.fillRect(Main.WIDTH - (int) (Main.WIDTH/3),0, (int) (Main.WIDTH/3), 50);
		g.setColor(Color.BLACK);
		g.drawRect(Main.WIDTH - (int) (Main.WIDTH/3), 0, (int) (Main.WIDTH/3), 50);
		g.drawRect(Main.WIDTH - (int) (Main.WIDTH/3+1), 1, (int) (Main.WIDTH/3)-1, 50-1);
		g.drawRect(Main.WIDTH - (int) (Main.WIDTH/3+2), 2, (int) (Main.WIDTH/3)-2, 50-2);
		g.setFont(new Font("Sans", Font.PLAIN, 24));
		String mon = String.format("%.2f", money);
		g.drawString("$" + mon, Main.WIDTH-(int)(Main.WIDTH/3+20+2)+40, 30);
	}
}
