package astarsearch;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// let the user input file name for map, and choose heuristic function 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter file name: ");
		
		String fileName = scanner.next();
		
		System.out.print("choose heuristic function: ");
		
		int ch = scanner.nextInt();
		
		System.out.println(String.format("file name is %s, huristic function choosed %d", fileName, ch));
		
		Map map = new Map();
		
		map.readFile(fileName);
		
		map.printMap();
		
	}

}
