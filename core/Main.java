package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import game.Background;
import game.GameSim;

public class Main {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 100;
	private static Renderer drawer;
	private static final int MOVEAMOUNT = 5;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("HI");
		JFrame frame = new JFrame();
		drawer = new Renderer();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(drawer);
		
		boolean[] keys = new boolean[4];
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				switch(arg0.getKeyChar()) {
					case 'w':
						keys[0] = true;
						break;
					case 'a':
						keys[1] = true;
						break;
					case 's':
						keys[2] = true;
						break;
					case 'd':
						keys[3] = true;
						break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				switch(arg0.getKeyChar()) {
					case 'w':
						keys[0] = false;
						break;
					case 'a':
						keys[1] = false;
						break;
					case 's':
						keys[2] = false;
						break;
					case 'd':
						keys[3] = false;
						break;
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		
		RenderLayer layer = new RenderLayer("background");
		Background back = new Background("/res/test.png");
		layer.addObject(back);
		drawer.addRenderLayer(layer);
		
		GameSim.init();
		
		frame.setVisible(true);
		
		int tick = 0;
		while(true) {
			frame.repaint();
			if(keys[0]) {
				drawer.moveX(-MOVEAMOUNT);
			}
			if(keys[1]) {
				drawer.moveY(-MOVEAMOUNT);
			}
			if(keys[2]) {
				drawer.moveX(MOVEAMOUNT);
			}
			if(keys[3]) {
				drawer.moveY(MOVEAMOUNT);
			}
			if(tick % 10 == 0) { // 6 ticks per second
				GameSim.update();
			}
			tick++;
			Thread.sleep(16);
		}
	}
	
	public static void addRenderLayer(RenderLayer layer) {
		drawer.addRenderLayer(layer);
	}
}
