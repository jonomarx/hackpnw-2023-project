package core;

import java.io.IOException;

import javax.swing.JFrame;

import game.Background;
import game.GameSim;

public class Main {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 1;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("HI");
		JFrame frame = new JFrame();
		Renderer drawer = new Renderer();
		GameSim.init();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(drawer);
		frame.setVisible(true);
		
		RenderLayer layer = new RenderLayer("background");
		Background back = new Background("/res/test.png");
		layer.addObject(back);
		drawer.addRenderLayer(layer);
		
		
		int tick = 0;
		while(true) {
			frame.repaint();
			tick++;
			if(tick % 10 == 0) { // 6 ticks per second
				GameSim.update();
			}
			Thread.sleep(16);
		}
	}

}
