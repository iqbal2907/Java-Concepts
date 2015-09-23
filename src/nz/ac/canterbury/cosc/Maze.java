package nz.ac.canterbury.cosc;

import java.util.ArrayList;
import java.util.List;


public class Maze {
	
	private static List<Cell> mazeList = new ArrayList<Cell>();
	
	public static void main(String[] args) {

		ArrayList<Boolean> bits = null;

		int input = 0;
		String str = null;
		for (int i = 0; i < args.length; i++) {
			str = args[i];
			System.out.println(str);
			for (int j = 0; j < str.length(); j++) {
				switch (str.charAt(j)) {
					case 'A' :
						input = 10;
						break;
					case 'B' :
						input = 11;
						break;
					case 'C' :
						input = 12;
						break;
					case 'D' :
						input = 13;
						break;
					case 'E' :
						input = 14;
						break;
					case 'F' :
						input = 15;
						break;
					default :
						input = str.charAt(j)-48;
				}
				bits = new ArrayList<Boolean>();
				for (int k = 3; k >= 0; k--) {
					bits.add((input & (1 << k))!=0);
				}
				Cell cell = new Cell(i, j, bits.get(0), bits.get(1), bits.get(2), bits.get(3));
				mazeList.add(cell);
			}
		}
		System.out.println(mazeList);
	}
	
	private void search(Cell start, Cell end) {

	}
}

class Cell {
	int i,j;
	int f,g,h;
	boolean up,left,right,down;
	
	public Cell(int i, int j, boolean up, boolean left, boolean right, boolean down) {
		this.i = i;
		this.j = j;
		this.up = up;
		this.left = left;
		this.right = right;
		this.down = down;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (down ? 1231 : 1237);
		result = prime * result + f;
		result = prime * result + g;
		result = prime * result + h;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + (left ? 1231 : 1237);
		result = prime * result + (right ? 1231 : 1237);
		result = prime * result + (up ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (down != other.down)
			return false;
		if (f != other.f)
			return false;
		if (g != other.g)
			return false;
		if (h != other.h)
			return false;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		if (up != other.up)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [i=" + i + ", j=" + j + ", f=" + f + ", g=" + g + ", h="
				+ h + ", up=" + up + ", left=" + left + ", right=" + right
				+ ", down=" + down + "]";
	}
}
