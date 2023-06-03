package game;

public class Wind extends PowerPlant {
    private static final int WIDTH = 2;
	private static final int LENGTH = 2;
    private static final int pollution = 0;
	
	private int cost;
	private int x;
	private int y;

    public Wind (int posx, int posy, int width, int height, int cost, int pollution)
    {        
        super(posx, posy, width, height, cost, 0, "Wind", pollution, 2);
    }
}
