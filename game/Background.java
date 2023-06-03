package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Main;
import core.Renderable;

public class Background implements Renderable {
	BufferedImage image;
	
	public Background(String path) throws IOException {
		image = ImageIO.read(Background.class.getResourceAsStream(path));
	}

	@Override
	public void render(Graphics g, double xoffset, double yoffset) {
		g.drawImage(image, 0, 0, Main.WIDTH, Main.HEIGHT, null);
	}

}
