import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayMap map = new ArrayMap();
		// let the user input file name for map, and choose heuristic function 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter file name: ");
		
		String fileName = scanner.next();
		
		System.out.print("choose heuristic function: ");
		
		int ch = scanner.nextInt();
		
		System.out.println(String.format("file name is %s, huristic function choosed %d", fileName, ch));
		
		try {
			map.readFile(fileName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		map.printMap();
        

        AStar a = new AStar(map,ch);
        a.startSearch();
    }
}
