package game;

public class Office extends Consumer{
    private static int WIDTH = 1;
    private static int HEIGHT = 1;
    private static int price;
    private static int cashFlow;
    private static String name = "Office";
    private static int pollution = 0;
    private static int powerFlow= 1;
    private final int id = 6;
    
    public Office(int x, int y)
    {        
        super(x, y, WIDTH, HEIGHT, price, cashFlow, name, pollution, powerFlow);
    }
    
}
