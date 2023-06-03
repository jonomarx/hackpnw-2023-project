package core;

import java.awt.Graphics;
import java.util.ArrayList;


// a layer of rendering, split into stuff
public class RenderLayer {
	private String name;
	private ArrayList<Renderable> stuffToDraw = new ArrayList<>();
	
	public RenderLayer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addObject(Renderable r) {
		stuffToDraw.add(r);
	}
	
	public boolean removeObject(Renderable r) {
		for(Renderable obj : stuffToDraw) {
			if(obj == r) {
				stuffToDraw.remove(obj);
				return true;
			}
		}
		return false;
	}
	
	public void paint(Graphics g, int xoffset, int yoffset) {
		for(Renderable r: stuffToDraw) {
			r.render(g, xoffset, yoffset);
		}
	}
	// list of stuff to render... todo
}