package com.jp.year2015.mySolution.Exam1;

public class Game {

	public static void main(String[] args) {
		
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		if (rows > 500 || columns > 500) {
			System.out.println("Given arguments do not satisfy specifications");
			System.exit(-1);
		}
		System.out.println("R:" + rows + ", C:" + columns);

		Entry[][] arr = new Entry[rows][columns];

		for (int i = 2, j = 0, k = 0; i < args.length; i++) {
			if ((i - 2) % columns == 0 && (i - 2) != 0) {
				j++;
			}
			k = (i - 2) % columns;
			arr[j][k] = new Entry(j, k, Integer.parseInt(args[i]));
		}
		
		System.out.println("Input in matrix : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		Entry start = arr[0][3];
		int maxValue = getMaxFrom(start);
		System.out.println("Maximum value from "+start+" is : "+maxValue);
	}

	private static int getMaxFrom(Entry start) {
		
		return 0;
	}
}

class Entry implements Comparable<Entry> {
	private int i;
	private int j;
	private final int val;
	public boolean visited;
	private Entry parent;

	Entry(int i, int j, int val) {
		this.i = i;
		this.j = j;
		this.val = val;
	}

	public int getVal() {
		return val;
	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	public Entry getParent() {
		return parent;
	}
	public void setParent(Entry parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "(" + i + "," + j + "," + val + "," + parent + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	@Override
	public int compareTo(Entry o) {
		return o.getVal() - this.getVal();
	}

}

