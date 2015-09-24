package nz.ac.canterbury.cosc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Maze {

	private static Cell[][] mazeArray = null;
	private static int mazeMaxRow;
	private static int mazeMaxColumn;
	List<Cell> closeList = new LinkedList<Cell>();

	public static void main(String[] args) {

		if (args == null) {
			throw new IllegalArgumentException();
		}
		int max = 0;
		for (int i = 0; i < args.length; i++) {
			max = (args[i].length() > max) ? args[i].length() : max;
		}
		mazeMaxRow = args.length;
		mazeMaxColumn = max;

		Cell[][] array = new Cell[mazeMaxRow][mazeMaxColumn];
		ArrayList<Boolean> bits = null;

		int input = 0;
		String str = null;
		for (int i = 0; i < mazeMaxRow; i++) {
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
						input = str.charAt(j) - 48;
				}
				bits = new ArrayList<Boolean>();
				for (int k = 3; k >= 0; k--) {
					bits.add((input & (1 << k)) != 0);
				}
				Cell cell = new Cell(i, j, bits.get(0), bits.get(1),
						bits.get(2), bits.get(3));
				array[i][j] = cell;
			}
		}
		mazeArray = array;
//		printMaze();
		Cell start = mazeArray[0][mazeMaxRow - 1];
		Cell end = mazeArray[mazeMaxColumn - 1][0];
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		new Maze().search(start, end);
	}

	private static void printMaze() {
		for (int i = 0; i < mazeMaxColumn; i++) {
			for (int j = 0; j < mazeMaxRow; j++) {
				System.out.println(mazeArray[i][j]);
			}
		}
	}
	private void search(Cell start, Cell end) {
		Cell current = start;
		do {
			closeList.add(current);
			System.out.print(current + "->");
			current = getValidNeighbourCellToMove(current, end);
		} while (!current.equals(end));
		System.out.print(current);
	}

	private Cell getValidNeighbourCellToMove(Cell cell, Cell end) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		if (canMoveUp(cell.i - 1, cell.j)) {
			Cell up = mazeArray[cell.i - 1][cell.j];
			if (!closeList.contains(up)) {
				up.g = 10 + cell.g;
				up.h = getHuristicDistance(up, end);
				up.f = up.g + up.h;
				list.add(up);
			}
		}
		if (canMoveLeft(cell.i, cell.j - 1)) {
			Cell left = mazeArray[cell.i][cell.j - 1];
			if (!closeList.contains(left)) {
				left.g = 10 + cell.g;
				left.h = getHuristicDistance(left, end);
				left.f = left.g + left.h;
				list.add(left);
			}
		}
		if (canMoveRight(cell.i, cell.j + 1)) {
			Cell right = mazeArray[cell.i][cell.j + 1];
			if (!closeList.contains(right)) {
				right.g = 10 + cell.g;
				right.h = getHuristicDistance(right, end);
				right.f = right.g + right.h;
				list.add(right);
			}
		}
		if (canMoveDown(cell.i + 1, cell.j)) {
			Cell down = mazeArray[cell.i + 1][cell.j];
			if (!closeList.contains(down)) {
				down.g = 10 + cell.g;
				down.h = getHuristicDistance(down, end);
				down.f = down.g + down.h;
				list.add(down);
			}
		}
//		System.out.println("list : "+list);
		Collections.sort(list);
		return list.get(0);
	}

	private int getHuristicDistance(Cell up, Cell end) {
		return (int) Math.sqrt(((up.i - end.i) * (up.i - end.i))
				+ ((up.j - end.j) * (up.j - end.j)));
	}

	private boolean canMoveUp(int i, int j) {
		try {
			Cell cell = mazeArray[i][j];
			if (cell.up == true) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
	private boolean canMoveLeft(int i, int j) {
		try {
			Cell cell = mazeArray[i][j];
			if (cell.left == true) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
	private boolean canMoveRight(int i, int j) {
		try {
			Cell cell = mazeArray[i][j];
			if (cell.right == true) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
	private boolean canMoveDown(int i, int j) {
		try {
			Cell cell = mazeArray[i][j];
			if (cell.down == true) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
}

class Cell implements Comparable<Cell> {
	int i, j;
	int f, g, h;
	boolean up, left, right, down;

	public Cell(int i, int j, boolean up, boolean left, boolean right,
			boolean down) {
		this.i = i;
		this.j = j;
		this.up = up;
		this.left = left;
		this.right = right;
		this.down = down;
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
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [i=" + i + ", j=" + j + ", f=" + f + ", g=" + g + ", h="
				+ h + ", up=" + up + ", left=" + left + ", right=" + right
				+ ", down=" + down + "]";
	
//		return "(" + i + "," + j + ")";
	
	}

	@Override
	public int compareTo(Cell o) {
		return this.j - o.j;
	}
}
