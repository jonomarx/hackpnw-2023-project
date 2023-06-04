package game;

public class Residental extends Consumer {
    private static int WIDTH = 4;
    private static int HEIGHT = 4;
    private static int price;
    private static int cashFlow;
    private static String name = "Residental";
    private static int pollution;
    private static int powerFlow;

 public Residental(int xIn, int yIn)
 {
    super(xIn, yIn, WIDTH, HEIGHT, price, cashFlow, name, pollution, powerFlow);

 }
}
