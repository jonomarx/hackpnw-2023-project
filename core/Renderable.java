package core;

import java.awt.Graphics;

// a thing that can be rendered
public interface Renderable {
	public void render(Graphics g, int xoffset, int yoffset);
}
