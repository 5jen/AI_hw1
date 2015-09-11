import java.util.Enumeration;

/**
 * Created by root on 9/9/15.
 */
public class Node {
	Position position;
	Node from = null;
	double score = 0;
	String action;
	int direction = 0; //1 vertical 2 horizontal
	int nodeDepth = 0;
	double actCost;
	Node(Position pos) {
		position = pos;
	}

/*	Node(Position pos, Node f, int s, String c) {
		position = pos;
		from = f;
		score = s;
		action = c;
	}*/

	void setScore(int s) {
		score = s;
	}

	void setAction(String a) {
		action = a;
	}

	boolean isGoalNode(Position goalPos) {
		return position.isSamePosition(goalPos);
	}

	double g(Node nextNode, ArrayMap map) {
		double actionCost = 0;
		Position next = nextNode.position;
		nodeDepth++;
		System.out.println("Before go: " + this);
		if(position.x == next.x && (direction == 1)) {//vertical no turn
			if(Math.abs(position.y - next.y) == 1) {
				nextNode.action = "vertical forward";
			}else if(Math.abs(position.y - next.y) == 2) {
				actionCost += 3;
				nextNode.action = "vertical bash forward";
			}
		} else if(position.x == next.x && (direction == 2)) {//vertical turn
			if(Math.abs(position.y - next.y) == 1) {
				nextNode.action = "turn_to_vertical forward";
			} else if(Math.abs(position.y - next.y) == 2) {
				actionCost += 3;
				nextNode.action = "turn_to_vertical bash forward";
			}
			nextNode.direction = 1;
			actionCost += Math.ceil(map.newMap[position.y][position.x]/(double)3);
		} else if(position.y == next.y && (direction == 2)) {//horizontal no turn 
			if(Math.abs(position.x - next.x) == 1) {
				nextNode.action = "horizontal forward";
			} else if(Math.abs(position.x - next.x) == 2) {
				actionCost += 3;
				nextNode.action = "horizontal bash forward";
			}
		} else if(position.y == next.y && (direction == 1)) {//horizontal turn
			if(Math.abs(position.x - next.x) == 1) {
				nextNode.action = "turn_to_horizontal forward";
			} else if(Math.abs(position.x - next.x) == 2) {
				actionCost += 3;
				nextNode.action = "turn_to_horizontal bash forward";
			}
			nextNode.direction = 2;
			actionCost += Math.ceil(map.newMap[position.y][position.x]/(double)3);
		}
		System.out.println("After go:" + this);
		nextNode.actCost = map.newMap[next.y][next.x] + actionCost;
		return nextNode.actCost;
	}



	public String toString() {
		return "Node: " + position.toString() + " eva_Score: " + score +" dir: " +direction
				+ " Action: " + action + " the step: "+actCost;
	}
}
