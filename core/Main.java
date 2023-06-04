package core;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Background;
import game.GameSim;

public class Main {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCALE = 30;
	public static final int TICKSPERDAY = 6; // 4 hours
	private static Renderer drawer;
	private static final int MOVEAMOUNT = 5;

	public static void main(String[] args) throws InterruptedException, IOException {
		JFrame frame = new JFrame();
		drawer = new Renderer();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boolean[] start = {false};
		/*title.addListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start[0] = true;
				frame.setContentPane(drawer);
				frame.setVisible(true);
			}
		});
		frame.setContentPane(title);*/
		frame.setContentPane(drawer);
		
		RenderLayer layer = new RenderLayer("background");
		Background back = new Background("/res/test.png");
		layer.addObject(back);
		drawer.addRenderLayer(layer);
		
		GameSim.init();
		
		frame.setVisible(true);
		
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
		
		int tick = 0;
		while(true) {
			frame.repaint();
			if(tick % 3 == 0) {
				if(keys[0]) {
					drawer.moveX(MOVEAMOUNT);
				}
				if(keys[1]) {
					drawer.moveY(MOVEAMOUNT);
				}
				if(keys[2]) {
					drawer.moveX(-MOVEAMOUNT);
				}
				if(keys[3]) {
					drawer.moveY(-MOVEAMOUNT);
				}
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

class TitleScreen extends JPanel {
	JButton button;
	BufferedImage image;
	public TitleScreen() throws IOException {
		button = new JButton("Start!");
		add(button);
		image = ImageIO.read(TitleScreen.class.getResourceAsStream("/res/test.png"));
	}
	
	public void addListener(ActionListener al) {
		button.addActionListener(al);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, Main.WIDTH, Main.HEIGHT, null);
	}
}
