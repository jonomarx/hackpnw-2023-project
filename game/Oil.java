package game;
import java.util.*;
public class Oil extends PowerPlant {
	private static int WIDTH = 1;
	private static int LENGTH = 1;
	private static int pollution = 15;
	private static int cost = 60;
	private static int x;
	private static int y;
	private static int cashflow = -20;
	
	//coal constructor

	public Oil (int posx, int posy) {
		super(posx, posy, WIDTH, LENGTH, 60, cashflow, "Natural Gas", 15, 75, 3, new int[][][] {{{40,41,42,43}}});

		x=posx;
		y=posy;
		
	}
}