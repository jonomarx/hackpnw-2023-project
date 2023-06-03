package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// holds images
public class SpriteSheet {
	private BufferedImage image;
	private int length;
	private int height;
	private int imgSize;
	
	public SpriteSheet(String imgLoc, int imgSize) throws IOException {
		image = ImageIO.read(new File(imgLoc));
		length = image.getWidth()/imgSize;
		height = image.getHeight()/imgSize;
		this.imgSize = imgSize;
	}
	
	public BufferedImage getImage(int id) {
		int x = id % length;
		int y = id / length;
		return image.getSubimage(x, y, imgSize, imgSize);
	}
}
