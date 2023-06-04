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
	private static int[][][] animData = {
			{{45,81},{54,90},{63},{72}},
			{{46,82},{55,91},{64},{73}},
			{{47,83},{56,92},{65},{74}},
			{{48,84},{57,93},{66},{75}},
			{{49,85},{58,94},{67},{76}},
			{{50,86},{59,95},{68},{77}},
			{{51,87},{60,96},{69},{78}},
			{{52,88},{61,97},{70},{79}},
			{{53,89},{62,98},{71},{80}},
	};
	
	//coal constructor
	public Nuclear (int posx, int posy) {
		super(posx, posy, 9, 4, 100, -80, "Nuclear", 0, 100, 2, animData);

		x=posx;
		y=posy;
		
	}	
}
