package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Main;
import core.Renderable;

public class HappinessMeter implements Renderable {
	private BufferedImage[] faces = new BufferedImage[5];
	private double happiness = 50;
	private String factors = "";
	
	public HappinessMeter() throws IOException {
		faces[0] = ImageIO.read(HappinessMeter.class.getResourceAsStream("/res/faces/happy.png"));
		faces[1] = ImageIO.read(HappinessMeter.class.getResourceAsStream("/res/faces/less_happy.png"));
		faces[2] = ImageIO.read(HappinessMeter.class.getResourceAsStream("/res/faces/neutral.png"));
		faces[3] = ImageIO.read(HappinessMeter.class.getResourceAsStream("/res/faces/sad.png"));
		faces[4] = ImageIO.read(HappinessMeter.class.getResourceAsStream("/res/faces/angry.png"));
	}
	
	public void setHappiness(double amount) {
		happiness = amount;
	}
	
	public void setFactorsText(String text) {
		factors = text;
	}

	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) (Main.WIDTH/2.5), Main.HEIGHT/5);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (int) (Main.WIDTH/2.5), Main.HEIGHT/5);
		g.drawRect(1, 1, (int) (Main.WIDTH/2.5)-1, Main.HEIGHT/5-1);
		g.drawRect(2, 2, (int) (Main.WIDTH/2.5)-2, Main.HEIGHT/5-2);
		BufferedImage image;
		if(happiness >= 80) {
			image = faces[0];
		} else if(happiness >= 60) {
			image = faces[1];
		} else if(happiness >= 40) {
			image = faces[2];
		} else if(happiness >= 20) {
			image = faces[3];
		} else {
			image = faces[4];
		}
		String hp = String.format("%.2f", happiness);
		g.drawImage(image, 1, 1, (int) (Main.WIDTH/2.5)/2, Main.HEIGHT/5, null);
		g.drawString("Happiness: " + hp + "\n" + factors, (int) (Main.WIDTH/3.5)/2 + 30, 15);
	}

}
