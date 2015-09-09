package astarsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
 static int [][] newMap = new int[10][10];
 static int row; //y size 
 static int col; //x size
 static int gpx; //goal position x
 static int gpy; //goal position y 
 static int spx; //start position x
 static int spy; //start position y
 
 
 static void readFile(String fileName) throws IOException{
	 fileName = "map01.txt";
	 BufferedReader br = new BufferedReader(new FileReader(fileName));
	 
	 String line;
	 row = 0;
	 
	 while ((line = br.readLine())!= null){
		 String[] vals = line.trim().split(" ");
		 col = vals.length;
		 for(int col = 0; col<vals.length;col++){
			 System.out.print(vals[col]+'\n');
			 if(vals[col].equals("G")){
				 newMap[row][col] = 'G';
				 gpx = col;
				 gpy = row;
			 }
			 else if(vals[col].equals("S")){
				 newMap[row][col] = 'S';
				 spx = col;
				 spy = row;
			 }
			 else{
				 newMap[row][col] = Integer.parseInt(vals[col]);
			 }
		 }
		 row++;
	 }
 }
 
 static void printMap(){
	 for(int x=0;x<row;x++){
		 for(int y=0;y<col;y++){
			 if(newMap[x][y]=='G'){
				 System.out.print("G ");
			 }
			 else if(newMap[x][y]=='S'){
				 System.out.print("S ");
			 }
			 else {
			 System.out.print(newMap[x][y]+" ");
			 }
		 }
		 System.out.print('\n');
	 }
 }
 
}
