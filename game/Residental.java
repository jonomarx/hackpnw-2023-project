package game;

public class Residental extends Consumer {
    private static int WIDTH = 4;
    private static int HEIGHT = 4;
    private static int price;
    private static int cashFlow;
    private static String name = "Residental";
    private static int pollution;
    private static int powerFlow;
    private static int[][][] animTable = new int[][][] {
		{{19}, {23}, {27}, {31}},
		{{20}, {24}, {28}, {32}},
		
		{{21}, {25}, {29}, {33}},
		{{22}, {26}, {30}, {34}},
	};

 public Residental(int xIn, int yIn)
 {
    super(xIn, yIn, WIDTH, HEIGHT, price, cashFlow, name, pollution, powerFlow, 6, animTable);

 }
}
