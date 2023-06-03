package core;

import javax.swing.JFrame;

public class Main {
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	public static final int SCALE = 1;

	public static void main(String[] args) {
		System.out.println("HI");
		JFrame frame = new JFrame();
		Renderer drawer = new Renderer();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(drawer);
		frame.setVisible(true);
	}

}
