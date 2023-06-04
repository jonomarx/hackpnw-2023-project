package core;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

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
	
	private static HashMap<Integer, Boolean> keys = new HashMap<>();

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
		//drawer.addRenderLayer(layer);
		
		GameSim.init();
		
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				keys.put(arg0.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				keys.put(arg0.getKeyCode(), false);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		
		int tick = 0;
		while(true) {
			frame.repaint();
			if(tick % 3 == 0) {
				if(Boolean.TRUE.equals(keys.get(KeyEvent.VK_W))) {
					drawer.moveX(MOVEAMOUNT);
				}
				if(Boolean.TRUE.equals(keys.get(KeyEvent.VK_A))) {
					drawer.moveY(MOVEAMOUNT);
				}
				if(Boolean.TRUE.equals(keys.get(KeyEvent.VK_S))) {
					drawer.moveX(-MOVEAMOUNT);
				}
				if(Boolean.TRUE.equals(keys.get(KeyEvent.VK_D))) {
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

	public static boolean getKey(int key) {
		return Boolean.TRUE.equals(keys.get(key));
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
