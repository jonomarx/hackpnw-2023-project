package core;

import javax.swing.JFrame;

import game.GameSim;

public class Main {
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	public static final int SCALE = 1;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("HI");
		JFrame frame = new JFrame();
		Renderer drawer = new Renderer();
		GameSim sim = new GameSim();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(drawer);
		frame.setVisible(true);
		
		int tick = 0;
		while(true) {
			frame.repaint();
			tick++;
			if(tick % 12 == 0) {
				GameSim.update();
			}
			Thread.sleep(16);
		}
	}

}
