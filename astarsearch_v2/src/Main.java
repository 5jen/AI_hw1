import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ArrayMap map = new ArrayMap();
        try {
            map.readFile("map01.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        AStar a = new AStar(map);
        a.startSearch();
    }
}
