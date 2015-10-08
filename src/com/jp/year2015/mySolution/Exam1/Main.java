package com.jp.year2015.mySolution.Exam1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO Remove package name before submission

public class Main {

	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		if (rows > 500 || columns > 500) {
			throw new IllegalArgumentException(
					"Given arguments do not satisfy specifications");
		}
		System.out.println("R:" + rows + ", C:" + columns);

		int[][] arr = new int[rows][columns];

		for (int i = 2, j = 0, k = 0; i < args.length; i++) {
			if ((i - 2) % columns == 0 && (i - 2) != 0) {
				j++;
			}
			k = (i - 2) % columns;
			arr[j][k] = Integer.parseInt(args[i]);
		}

		System.out.println("Input in matrix : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// creating object map
		Map<Integer, Cell> objMap = new HashMap<Integer, Cell>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (arr[i][j] != -1) {
					Cell cell = new Cell(i, j, arr[i][j]);
					cell.setHashValue(cell.hashCode());
					objMap.put(cell.hashCode(), cell);
				}
			}
		}
		// System.out.println("Object Map : \n" + objMap);

		Map<Integer, List<Cell>> adjMap = new HashMap<Integer, List<Cell>>();

		// preparing adjacency list here
		for (int i = 1; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
				if (arr[i][j] != -1) {
					Cell node = new Cell(i, j, arr[i][j]);
					List<Cell> list = new ArrayList<Cell>(3);

					// up
					if (arr[i - 1][j] != -1) {
						Cell nd = new Cell(i - 1, j, arr[i - 1][j]);
						list.add(objMap.get(nd.hashCode()));
					}
					// front
					if (arr[i][j + 1] != -1) {
						Cell nd = new Cell(i, j + 1, arr[i][j + 1]);
						list.add(objMap.get(nd.hashCode()));
					}
					// down
					if (arr[i + 1][j] != -1) {
						Cell nd = new Cell(i + 1, j, arr[i + 1][j]);
						list.add(objMap.get(nd.hashCode()));
					}
					adjMap.put(node.hashCode(), list);
				}
			}
		}

		// adding first row
		for (int j = 0; j < columns - 1; j++) {
			Cell node = new Cell(0, j, arr[0][j]);
			List<Cell> list = new ArrayList<Cell>(3);
			// up
			if (arr[rows - 1][j] != -1) {
				Cell nd = new Cell(rows - 1, j, arr[rows - 1][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			// front
			if (arr[0][j + 1] != -1) {
				Cell nd = new Cell(0, j + 1, arr[0][j + 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			// down
			if (arr[1][j] != -1) {
				Cell nd = new Cell(1, j, arr[1][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			adjMap.put(node.hashCode(), list);
		}

		// adding last row
		for (int i = rows - 1, j = 0; j < columns - 1; j++) {
			Cell node = new Cell(i, j, arr[i][j]);
			List<Cell> list = new ArrayList<Cell>(3);
			// up
			if (arr[i - 1][j] != -1) {
				Cell nd = new Cell(i - 1, j, arr[i - 1][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			// front
			if (arr[i][j + 1] != -1) {
				Cell nd = new Cell(i, j + 1, arr[i][j + 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			// down
			if (arr[0][j] != -1) {
				Cell nd = new Cell(0, j, arr[0][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			adjMap.put(node.hashCode(), list);
		}

		// adding last column
		for (int i = 1, j = columns - 1; i < rows - 1; i++) {
			Cell node = new Cell(i, j, arr[i][j]);
			List<Cell> list = new ArrayList<Cell>(2);
			// up
			if (arr[i - 1][j] != -1) {
				Cell nd = new Cell(i - 1, j, arr[i - 1][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			// down
			if (arr[i + 1][j] != -1) {
				Cell nd = new Cell(i + 1, j, arr[i + 1][j]);
				list.add(objMap.get(nd.hashCode()));
			}
			adjMap.put(node.hashCode(), list);
		}

		//adding right top corner
		Cell node = new Cell(0, columns-1, arr[0][columns-1]);
		List<Cell> list = new ArrayList<Cell>(2);
		//up
		if (arr[rows-1][columns-1] != -1) {
			Cell nd = new Cell(rows - 1, columns-1, arr[rows-1][columns-1]);
			list.add(objMap.get(nd.hashCode()));
		}
		//down
		if (arr[1][columns-1] != -1) {
			Cell nd = new Cell(1, columns-1, arr[1][columns-1]);
			list.add(objMap.get(nd.hashCode()));
		}
		adjMap.put(node.hashCode(), list);
		
		//adding right bottom corner
		node = new Cell(rows-1, columns-1, arr[rows-1][columns-1]);
		list = new ArrayList<Cell>(2);
		//up
		if (arr[rows-2][columns-1] != -1) {
			Cell nd = new Cell(rows - 2, columns-1, arr[rows-2][columns-1]);
			list.add(objMap.get(nd.hashCode()));
		}
		//down
		if (arr[0][columns-1] != -1) {
			Cell nd = new Cell(0, columns-1, arr[0][columns-1]);
			list.add(objMap.get(nd.hashCode()));
		}
		adjMap.put(node.hashCode(), list);

		System.out.println("\n\nAdjacency Map : \n" + adjMap);

	}
}

class Cell implements Comparable<Cell> {
	private int x;
	private int y;
	private int val;
	public boolean visited;
	public int hashValue;

	Cell() {
	}
	Cell(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	public int getHashValue() {
		return hashValue;
	}
	public void setHashValue(int hashValue) {
		this.hashValue = hashValue;
	}
	public int getVal() {
		return val;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + val + "," + hashValue + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public int compareTo(Cell o) {
		return o.getVal() - this.getVal();
	}

}
