package game;
import java.util.*;
public class Nuclear extends PowerPlant{
	private final int WIDTH = 1;
	private final int LENGTH = 1;
	private final int pollution = 0;
	private final int cost = 100;
	private final int x;
	private final int y;
	private final int cashflow = -80;
	
	//coal constructor
	public Nuclear (int posx, int posy) {
		super(posx, posy, 1, 1, 100, -80, "Nuclear", 0, 100, 2);

		x=posx;
		y=posy;
		
	}	
}
