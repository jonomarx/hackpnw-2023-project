package game;

public class Road extends Building {
    private static int x;
    private static int y;
    private static boolean horizontal;

    public Road(int xIn, int yIn, boolean horizontalIn)
    {
        super(x, y, 1, 1, 0, 0, "Road", 0, 0, 8);
        x = xIn;
        y = yIn;
        horizontal = horizontalIn;
    }
}
