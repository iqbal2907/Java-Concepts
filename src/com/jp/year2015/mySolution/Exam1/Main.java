package com.jp.year2015.mySolution.Exam1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// TODO Remove package name before submission

public class Main {

	private static Map<Integer, List<Cell>> adjMap = new HashMap<Integer, List<Cell>>();
	private static Map<Integer, Cell> objMap = new HashMap<Integer, Cell>();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		long time = System.currentTimeMillis();

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
		createObjectMap(rows, columns, arr);
//		System.out.println("Object Map : \n" + objMap);

		createAdjacencyMap(rows, columns, arr);
		// preparing adjacency list here

//		System.out.println("\n\nAdjacency Map : \n" + adjMap);
		Cell start = null;
		int maxValue = 0 ;
/*		for (int i = 0; i < rows; i++) {
			if (arr[i][0] != -1) {
				Cell cell = new Cell(i, 0, arr[i][0]);
				if (getMaxFrom(cell) > maxValue) {
					maxValue = getMaxFrom(cell);
					start = cell;
				}
			}
		}
*/		
		Cell cell = new Cell(3, 0, arr[3][0]);
		System.out.println("Calculating max from : "+cell);
		maxValue = getMaxFrom(cell);
		System.out.println("Final max value : "+maxValue);
		System.out.println("Execution time : "
				+ (System.currentTimeMillis() - time));
	}

	private static int getMaxFrom(Cell cell){
		int max = 0;
		int noOfChilds = 0;

		Stack<Cell> st = new Stack<Cell>();
		st.push(cell);
		cell.visited = true;
		Cell child = null;
		while ((child = getUnvisitedChildNode(cell)) != null) {
			noOfChilds++;
			st.add(child);
//			child.visited = true;
		}
		if (noOfChilds != 0) {
			Cell c = null;
			while (!st.isEmpty() && (st.size()>1)) {
				c = st.pop();
				int m = getMaxFrom(c);
				c.visited = false;
				max = max > m ? max : m;
			}
			c = st.pop();
			max += c.getVal();
		} else {
			max = cell.getVal();
		}
		System.out.println(cell +":"+ max);
//		resetMap(cell);
		return max;
	}
	
	private static Cell getUnvisitedChildNode(Cell cell) {
		List<Cell> list = adjMap.get(cell.hashCode());
		if (list != null) {
			Iterator<Cell> itr = list.iterator();
			while (itr.hasNext()) {
				Cell c = itr.next();
				if (!c.visited) {
					c.visited = true;
					return c;
				}
			}
		}
		return null;
	}

	private static void resetMap(Cell cell) {
		Stack<Cell> s = new Stack<Cell>();
		s.push(cell);
		cell.visited = false;
		while (!s.isEmpty()) {
			Cell n = s.peek();
			Cell child = getVisitedChildNode(n);
			if (child != null) {
				cell.visited = true;
				s.push(child);
			} else {
				s.pop();
			}
		}
	
	}
	
	private static Cell getVisitedChildNode(Cell n) {
		List<Cell> list = adjMap.get(n.hashCode());
		if (list != null) {
			Iterator<Cell> itr = list.iterator();
			while (itr.hasNext()) {
				Cell node = itr.next();
				if (node.visited) {
					node.visited = false;
					return node;
				}
			}
		}
		return null;
	}
	private static void createObjectMap(int rows, int columns, int[][] arr) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (arr[i][j] != -1) {
					Cell cell = new Cell(i, j, arr[i][j]);
					cell.setHashValue(cell.hashCode());
					objMap.put(cell.hashCode(), cell);
				}
			}
		}
	}

	private static void createAdjacencyMap(int rows, int columns, int[][] arr) {
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
			if (arr[0][j] != -1) {
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
		}

		// adding last row
		for (int i = rows - 1, j = 0; j < columns - 1; j++) {
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
				if (arr[0][j] != -1) {
					Cell nd = new Cell(0, j, arr[0][j]);
					list.add(objMap.get(nd.hashCode()));
				}
				adjMap.put(node.hashCode(), list);
			}
		}

		// adding last column
		for (int i = 1, j = columns - 1; i < rows - 1; i++) {
			if (arr[i][j] != -1) {
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
		}
		// adding right top corner
		if (arr[0][columns - 1] != -1) {
			Cell node = new Cell(0, columns - 1, arr[0][columns - 1]);
			List<Cell> list = new ArrayList<Cell>(2);
			// up
			if (arr[rows - 1][columns - 1] != -1) {
				Cell nd = new Cell(rows - 1, columns - 1,
						arr[rows - 1][columns - 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			// down
			if (arr[1][columns - 1] != -1) {
				Cell nd = new Cell(1, columns - 1, arr[1][columns - 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			adjMap.put(node.hashCode(), list);
		}
		// adding right bottom corner
		if (arr[rows - 1][columns - 1] != -1) {
			Cell node = new Cell(rows - 1, columns - 1,
					arr[rows - 1][columns - 1]);
			List<Cell> list = new ArrayList<Cell>(2);
			// up
			if (arr[rows - 2][columns - 1] != -1) {
				Cell nd = new Cell(rows - 2, columns - 1,
						arr[rows - 2][columns - 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			// down
			if (arr[0][columns - 1] != -1) {
				Cell nd = new Cell(0, columns - 1, arr[0][columns - 1]);
				list.add(objMap.get(nd.hashCode()));
			}
			adjMap.put(node.hashCode(), list);
		}
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
