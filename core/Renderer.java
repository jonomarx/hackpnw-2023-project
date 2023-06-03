package core;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Renderer extends JPanel {
	// camera position, offsets tiles and game objects
	private int x = 0;
	private int y = 0;
	// manage something involving stuff to render and the order of it
	private ArrayList<RenderLayer> layers = new ArrayList<>();
	
	public void Renderer() {
		
	}
	
	public void addRenderLayer(RenderLayer layer) {
		layers.add(layer);
	}
	
	public void paintComponent(Graphics g) {
		for(RenderLayer layer : layers) {
			layer.paint(g, x, y);
		}
	}
}
