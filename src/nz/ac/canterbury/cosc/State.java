package nz.ac.canterbury.cosc;
// State Class for EightPuzzle; extends State
//
//   public Vector successors()
//   public int estimate(State goal)
//
// Doi need an unary constructor?
//
import java.util.Vector;
public class State {
  public int[] value;        // object data repr.; should be of length 9
  // constructor
  public State(int[] v) {
    value = v;
  }
  // equality check
  public boolean equals(State state) {
	 State s = (State)state;
    boolean flag = true;
    for (int i = 0; i < 9; i++) if (value[i] != s.value[i]) flag = false;
    return flag;
  }
  // to String conversion; for printing
  public String toString() {
    String s = "(";
    for (int i = 0; i < 9; i++)
      s = s + value[i] + ",";    
    return s + "\b)";
  }
  // successor states
  public Vector successors() {
	 Vector m = new Vector();
    // ***** ////////How to do this??????*****
/*
//
int dx = ap.dimx;  ?????the direction???
int dy = ap.dimy;
int blank = EightPuzzle.blank; ?????????? error how to define the blank???
int i = 0;
	for(int y = 0; y < dy; y++){
	     for(int x = 0; x < dx; x++){
	if((y >    0)  && (value[i- dx]    == blank))   m.addElement(flip(i, i-dx)); 
	if((y < dy-1) && (value[i+ dx] == blank))   m.addElement(flip(i, i+dx));
	if((x >    0)  && (value[i-  1]    == blank))    m.addElement(flip(i, i- 1));
	if((x < dx-1) && (value[i+  1] == blank))     m.addElement(flip(i, i+ 1));
	i++;
  	}
}
	 //
*/
	 return m;
  }
  // interface to estimate h
  public int estimate(State goal) {
    // ***** Here the Manhattan heuristic is implemented but how*****
	 return 0;
  }
}  // End class EightPuzzleState