import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayMap {
    int [][] newMap = new int[10][10];
    int row; //y size
    int col; //x size
    int gpx; //goal position x
    int gpy; //goal position y
    int spx; //start position x
    int spy; //start position y


    void readFile(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        row = 0;

        while ((line = br.readLine())!= null){
            String[] vals = line.trim().split(" ");
            col = vals.length;
            for(int col = 0; col<vals.length;col++){
                System.out.print(vals[col]+'\n');
                if(vals[col].equals("G")){
                    newMap[row][col] = 1;
                    gpx = col;
                    gpy = row;
                }
                else if(vals[col].equals("S")){
                    newMap[row][col] = 1;
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

    void printMap(){
        for(int y=0;y<row;y++){
            for(int x=0;x<col;x++){
                if(newMap[y][x]=='G'){
                    System.out.print("G ");
                }
                else if(newMap[y][x]=='S'){
                    System.out.print("S ");
                }
                else {
                    System.out.print(newMap[y][x]+" ");
                }
            }
            System.out.print('\n');
        }
    }

    Position giveUp(Position p) {
    	Position up = null;
    	if(p.y - 1 >= 0) {
    	up = new Position(p.x, p.y - 1);
    	}
    	return up;
    	}

    	Position giveBashUp(Position p) {
    	Position bashUp = null;
    	if(p.y - 2 >= 0) {
    	bashUp = new Position(p.x, p.y - 2);
    	}
    	return bashUp;
    	}

    	Position giveDown(Position p) {
    	Position down = null;
    	int y_size = row;
    	if(p.y + 1 < y_size) {
    	down = new Position(p.x, p.y + 1);
    	}
    	return down;
    	}

    	Position giveBashDown(Position p) {
    	Position bashDown = null;
    	int y_size = row;
    	if(p.y + 2 < y_size) {
    	bashDown = new Position(p.x, p.y + 2);
    	}
    	return bashDown;
    	}

    	Position giveLeft(Position p) {
    	Position left = null;
    	if(p.x - 1 >= 0) {
    	left = new Position(p.x - 1, p.y);
    	}
    	return left;
    	}

    	Position giveBashLeft(Position p) {
    	Position bashLeft = null;
    	if(p.x - 2 >= 0) {
    	bashLeft = new Position(p.x - 2, p.y);
    	}
    	return bashLeft;
    	}

    	Position giveRight(Position p) {
    	Position right = null;
    	int x_size = col;
    	if(p.x + 1 < x_size) {
    	right = new Position(p.x + 1, p.y);
    	}
    	return right;
    	}

    	Position giveBashRight(Position p) {
    	Position bashRight = null;
    	int x_size = col;
    	if(p.x + 2 < x_size) {
    	bashRight = new Position(p.x + 2, p.y);
    	}
    	return bashRight;
    	}
}
