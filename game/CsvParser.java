package game;
import java.util.*;
public class CsvParser {
	Map<Integer, Double> map;
	public CsvParser(String filename) {
		Scanner scanner = new Scanner(Scanner.class.getResourceAsStream(filename));
		map = new HashMap<Integer, Double>();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] s = line.split(",");
			map.put(Integer.parseInt(s[0]), Double.parseDouble(s[1]));
		}
	}
}
