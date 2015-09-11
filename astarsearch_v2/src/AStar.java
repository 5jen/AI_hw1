import java.util.ArrayList;
import java.util.Set;


/**
 * Created by root on 9/9/15.
 */
public class AStar {
    ArrayList<Node> unexpanded = new ArrayList<>();
    ArrayMap map;
    boolean pathFound = false;
    Node goalNode;
    int direction = 0; 

    AStar(ArrayMap map) {
        this.map = map;
    }

    void startSearch() {
        Position startPos = new Position(map.spx, map.spy);
        Position goalPos = new Position(map.gpx, map.gpy);
        Node endNode;
        if((endNode = search(startPos, goalPos, map)) != null) {
            Node.printOutPath(endNode);
        }

    }

    Node search(Position start, Position goal, ArrayMap map) {
        Node startNode = new Node(start);
        startNode.direction = 1;
        unexpanded.add(startNode);
        double lowestScore = 0;
        Node lowestScoreNode = null;
 
        while(!pathFound) {
            lowestScoreNode = null;
            lowestScore = unexpanded.get(0).score;
            System.out.println("Unexpanded Node: ");
            for(Node node : unexpanded) {
                System.out.println(node);
                if (node.score <= lowestScore) {
                    //System.out.println("in yes");
                    lowestScore = node.score;
                    lowestScoreNode = node;
                }
            }
            System.out.println("The Lowest Score is " + lowestScore);

            if(lowestScoreNode.isGoalNode(goal)) {
                System.out.println("Found it!");
                pathFound = true;
                
            }
            else if(lowestScoreNode != null) {
                System.out.println("!null");
                expand(lowestScoreNode, goal, map);
                unexpanded.remove(lowestScoreNode);
            }
            //System.out.println(i++ + "loop end\n");
        }

        System.out.println("We Found the Goal");
        return lowestScoreNode;
    }

    void expand(Node curNode, Position goal, ArrayMap map) {
        System.out.println(curNode);
        Position upPos;
        if((upPos = map.giveUp(curNode.position)) != null){
            Node up = new Node(upPos);
            up.from = curNode;
            up.score = up.from.score;
            up.direction = up.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(up, map);
            //up.direction = up.from.direction;
            up.score += h_return + g_return;
//            if(up.isGoalNode(goal)) {
//                goalNode = up;
//            }
            if(curNode.from == null) {
                unexpanded.add(up);
            }
            else if(!curNode.from.position.isSamePosition(upPos)) {
                unexpanded.add(up);
            }
        }
        
        Position bashUp;
        if((bashUp=map.giveBashUp(curNode.position))!= null){
        	Node bashUpNode = new Node(bashUp);
        	bashUpNode.from = curNode;
        	bashUpNode.score = bashUpNode.from.score;
        	bashUpNode.direction = bashUpNode.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(bashUpNode, map);
            //bashUpNode.direction = bashUpNode.from.direction;
            bashUpNode.score += h_return + g_return;
            if(curNode.from==null || !curNode.from.position.isSamePosition(bashUp)){
            	unexpanded.add(bashUpNode);
            }    	
        }
        
        Position bashDown;
        if((bashDown=map.giveBashDown(curNode.position))!= null){
        	Node bashDownNode = new Node(bashDown);
        	bashDownNode.from = curNode;
        	bashDownNode.score = bashDownNode.from.score;
        	bashDownNode.direction = bashDownNode.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(bashDownNode, map);
            //bashDownNode.direction = bashDownNode.from.direction;
            bashDownNode.score += h_return + g_return;
            if(curNode.from==null || !curNode.from.position.isSamePosition(bashDown)){
            	unexpanded.add(bashDownNode);
            }    	
        }
        
        Position bashLeft;
        if((bashLeft=map.giveBashLeft(curNode.position))!= null){
        	Node bashLeftNode = new Node(bashLeft);
        	bashLeftNode.from = curNode;
        	bashLeftNode.score = bashLeftNode.from.score;
        	bashLeftNode.direction = bashLeftNode.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(bashLeftNode, map);
            //bashLeftNode.direction = bashLeftNode.from.direction;
            bashLeftNode.score += h_return + g_return;
            if(curNode.from==null || !curNode.from.position.isSamePosition(bashLeft)){
            	unexpanded.add(bashLeftNode);
            }    	
        }
        
        Position bashRight;
        if((bashRight=map.giveBashRight(curNode.position))!= null){
        	Node bashRightNode = new Node(bashRight);
        	bashRightNode.from = curNode;
        	bashRightNode.score = bashRightNode.from.score;
        	bashRightNode.direction = bashRightNode.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(bashRightNode, map);
            //bashRightNode.direction = bashRightNode.from.direction;
            bashRightNode.score += h_return + g_return;
            if(curNode.from==null || !curNode.from.position.isSamePosition(bashRight)){
            	unexpanded.add(bashRightNode);
            }    	
        }
        
        Position downPos;
        if((downPos = map.giveDown(curNode.position)) != null){
            Node down = new Node(downPos);
            down.from = curNode;
            down.score = down.from.score;
            down.direction = down.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(down, map);
            //down.direction = down.from.direction;
            down.score += h_return + g_return;
            if(downPos.isSamePosition(goal)) {
                goalNode = down;
            }
            if(curNode.from == null) {
                unexpanded.add(down);
            }
            else if(!curNode.from.position.isSamePosition(downPos)) {
                unexpanded.add(down);
            }
        }

        Position leftPos;
        if((leftPos = map.giveLeft(curNode.position)) != null){
            Node left = new Node(leftPos);
            left.from = curNode;
            left.score = left.from.score;
            left.direction = left.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(left, map);
            //left.direction = left.from.direction;
            left.score += h_return + g_return;
            if(curNode.from == null) {
                unexpanded.add(left);
            }
            else if(!curNode.from.position.isSamePosition(leftPos)) {
                unexpanded.add(left);
            }
        }

        Position rightPos;
        if((rightPos = map.giveRight(curNode.position)) != null){
            Node right = new Node(rightPos);
            right.from = curNode;
            right.score = right.from.score;
            right.direction = right.from.direction;
            double h_return = h(curNode.position, goal, 1);
            double g_return = curNode.g(right, map);
            //right.direction = right.from.direction;
            right.score += h_return + g_return;
            if(curNode.from == null) {
                unexpanded.add(right);
            }
            else if(!curNode.from.position.isSamePosition(rightPos)) {
                unexpanded.add(right);
            }
        }
    }

    int g(Position next, ArrayMap map) {

        return map.newMap[next.y][next.x];
    }

    int h(Position cur, Position goal, int option) {
        int ret = 0;
        switch(option) {
            case 1:
                ret = h1();
            break;
            case 2:
                ret = h2(cur, goal);
            break;
            case 3:
                ret =  h3(cur, goal);
            break;
            case 4:
                ret =  h4(cur, goal);
            break;
            case 5:
                ret =  h5(cur, goal);
            break;
            case 6:
                ret =  h6(cur, goal);
            break;
            default:
                System.out.println("default should not occur");
            break;
        }
        return ret;
    }

    int h1() {
        return 0;
    }

    int h2(Position cur, Position goal) {
        return Math.min(Math.abs(cur.x - goal.x), Math.abs(cur.y - goal.y));
    }

    int h3(Position cur, Position goal) {
        return Math.max(Math.abs(cur.x - goal.x), Math.abs(cur.y - goal.y));
    }

    int h4(Position cur, Position goal) {
        return 0;
    }

    int h5(Position cur, Position goal) {
        return 0;
    }

    int h6(Position cur, Position goal) {
        return 0;
    }
}
