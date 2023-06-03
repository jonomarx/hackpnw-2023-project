package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// holds images
public class SpriteSheet {
	private BufferedImage image;
	private length
	
	public SpriteSheet(String imgLoc, int imgSize) throws IOException {
		image = ImageIO.read(new File(imgLoc));
	}
	
	public BufferedImage getImage(int id) {
		
	}
}
