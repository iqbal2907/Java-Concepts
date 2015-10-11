package com.jp.year2015.mySolution.Exam1;

import java.util.Stack;

public class Game {

	private static Entry[][] arr = null;
	private static int row;
	private static int column;
	private static int maximum;
	public static void main(String[] args) {

		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		if (rows > 500 || columns > 500) {
			System.out.println("Given arguments do not satisfy specifications");
			System.exit(-1);
		}
		System.out.println("R:" + rows + ", C:" + columns);

		row = rows - 1;
		column = columns - 1;
		arr = new Entry[rows][columns];

		for (int i = 2, j = 0, k = 0; i < args.length; i++) {
			if ((i - 2) % columns == 0 && (i - 2) != 0) {
				j++;
			}
			k = (i - 2) % columns;
			if (Integer.parseInt(args[i]) != -1) {
				arr[j][k] = new Entry(j, k, Integer.parseInt(args[i]));
			}
		}

		System.out.println("Input in matrix : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (arr[i][j] != null) {
					System.out.print(arr[i][j].getVal() + " ");
				} else {
					System.out.print(-1 + " ");
				}
			}
			System.out.println();
		}

		Entry start = arr[3][0];
		int maxValue = 0;
		maxValue = getMaxFrom(start);
		System.out.println("Maximum value from " + start + " is : " + maxValue);
	}

	private static int getMaxFrom(Entry start) {
		int max = 0, preMax = 0, curMax = 0;
		Stack<Entry> stack = new Stack<Entry>();
		// get max from up
		if (start.getI() > 0) {
			Entry up = arr[start.getI() - 1][start.getJ()];
			if (up != null && !up.equals(start.getParent())) {
				up.setParent(start);
				stack.push(up);
			}
		}
		// get max from front
		if (start.getJ() < column) {
			Entry front = arr[start.getI()][start.getJ() + 1];
			if (front != null && !front.equals(start.getParent())) {
				front.setParent(start);
				stack.push(front);
			}
		}
		// get max from down
		if (start.getI() < row) {
			Entry down = arr[start.getI() + 1][start.getJ()];
			if (down != null && !down.equals(start.getParent())) {
				down.setParent(start);
				stack.push(down);
			}
		}
		if (stack.isEmpty()) {
			System.out.println("Start : " + start);
			return start.getVal();
		}
		while (!stack.isEmpty()) {
			Entry entry = stack.pop();
			curMax = getMaxFrom(entry);
			max += start.getVal() + curMax;
			System.out.println(" Max : " + max + " curMax : " + curMax);
		}
		System.out.println("Start : " + start + " Max : " + max);
		return max;
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
