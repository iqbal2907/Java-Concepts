package nz.ac.canterbury.cosc;
import java.util.Vector;
public class EightPuzzle extends AStar {
	// constructor
	public EightPuzzle(Node i, Node g) {
		initialnode = i;
		goalnode = g;
	}

	static int initarray[] = {1, 2, 3, 4, 0, 8, 7, 6, 5};
	static int goalarray[] = {1, 2, 3, 4, 5, 6, 7, 8, 0};
	int blank = 4;

	public static void main(String[] args) {
		State initsta = new State(initarray);
		State goalsta = new State(goalarray);
//		Node in = new Node(estadoinicial, 0);
//		Node go = new Node(esmeta, 0);
//		EightPuzzle a = new EightPuzzle(in, go);
//		a.solve(); // this function is in AStar
	}
	//
} // END EightPuzzle class