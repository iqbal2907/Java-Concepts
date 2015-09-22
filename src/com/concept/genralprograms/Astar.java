package com.concept.genralprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Astar {

	private static int checkpointsCount;
	private static Square start;
	private static Square goal;
	private static char[][] arr;

	List<Square> openList = new LinkedList<Square>();
	List<Square> closeList = new LinkedList<Square>();
	List<Point> finalPathList = new LinkedList<Point>();

	private static List<Square> checkpoints = new ArrayList<Square>();

	public void search() {
		Square source = start;
		Square destination = null;
		while (!checkpoints.isEmpty()) {
			destination = new Astar().getNearestCheckPoint(source);
			checkpoints.remove(destination);
			aStarSearch(source, destination);
			source = destination;
		}
		// finally pass goal node
		aStarSearch(source, goal);
		if (!finalPathList.contains(goal.getParent())) {
			finalPathList.add(goal.getParent());
		}

		System.out.println("finalPathList : "+finalPathList);

	}
	public void aStarSearch(Square start, Square destination) {
		Square current = start;
		System.out.println("\nstart : " + start);
		System.out.println("destination : " + destination);

		Square left = null;
		Square right = null;
		Square up = null;
		Square down = null;
		int x = -1;
		int y = -1;
		List<Point> pathList = new LinkedList<Point>();

		closeList.clear();
		openList.clear();
		if (!pathList.contains(start.getParent())) {
			pathList.add(start.getParent());
		}
		do {
			// Apply A* here
			closeList.add(current);
			x = current.getPt().getX();
			y = current.getPt().getY();
			if (checkWithinLimit(x - 1, y)) {
				left = new Square(arr[x - 1][y], x - 1, y);
				left.setParent(current.getPt());
				left.setH((int) getDistanceBetweenSquares(current, destination) * 10);
				left.setG(current.getG() + 10);
				left.setF(left.getG() + left.getH());
				if (!openList.contains(left) && !closeList.contains(left)) {
					openList.add(left);
				}
			}
			if (checkWithinLimit(x + 1, y)) {
				right = new Square(arr[x + 1][y], x + 1, y);
				right.setParent(current.getPt());
				right.setH((int) getDistanceBetweenSquares(current, destination) * 10);
				right.setG(current.getG() + 10);
				right.setF(right.getG() + right.getH());
				if (!openList.contains(right) && !closeList.contains(right)) {
					openList.add(right);
				}
			}
			if (checkWithinLimit(x, y - 1)) {
				down = new Square(arr[x][y - 1], x, y - 1);
				down.setParent(current.getPt());
				down.setH((int) getDistanceBetweenSquares(current, destination) * 10);
				down.setG(current.getG() + 10);
				down.setF(down.getG() + down.getH());
				if (!openList.contains(down) && !closeList.contains(down)) {
					openList.add(down);
				}
			}
			if (checkWithinLimit(x, y + 1)) {
				up = new Square(arr[x][y + 1], x, y + 1);
				up.setParent(current.getPt());
				up.setH((int) getDistanceBetweenSquares(current, destination) * 10);
				up.setG(current.getG() + 10);
				up.setF(up.getG() + up.getH());
				if (!openList.contains(up) && !closeList.contains(up)) {
					openList.add(up);
				}
			}
			Collections.sort(openList);
			current = openList.remove(0);
			if (!pathList.contains(current.getParent())) {
				pathList.add(current.getParent());
			}
		} while (!current.equals(destination));
		finalPathList.addAll(pathList);
/*		System.out.println("pathList : "+pathList);
		System.out.println("end : "+current);
		System.out.println("####################################################");
*/	}

	private boolean checkWithinLimit(int i, int j) {
		try {
			@SuppressWarnings("unused")
			char ch = arr[i][j];
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		if (arr[i][j] == '#') {
			return false;
		}
		return true;
	}
	public Square getNearestCheckPoint(Square start) {
		Square nearest = null;
		Square square = null;
		double d = 1000000000;
		double dis = 0;
		Iterator<Square> iterator = checkpoints.iterator();
		while (iterator.hasNext()) {
			square = (Square) iterator.next();
			dis = getDistanceBetweenSquares(start, square);
			if (dis <= d) {
				d = dis;
				nearest = square;
			}
		}
		return nearest;
	}

	private double getDistanceBetweenSquares(Square start, Square square) {
		return Math.sqrt(((start.getPt().getX() - square.getPt().getX()) * (start.getPt().getX() - square.getPt()
				.getX()))
				+ ((start.getPt().getY() - square.getPt().getY()) * (start.getPt().getY() - square.getPt().getY())));
	}
	public static void main(String[] args) {

		int width = Integer.parseInt(args[0]);
		int hight = Integer.parseInt(args[1]);

		if (width > 100 || hight > 100) {
			System.out.println("Given arguments do not satisfy specifications");
			System.exit(-1);
		}
		System.out.println("\nwidth(j) : " + width + "\nhight(i) : " + (hight - 2));
		System.out.println();
		arr = new char[hight][width];
		String row;

		for (int i = 2; i < hight; i++) {
			row = args[i];
			for (int j = 0; j < row.length(); j++) {
				arr[i - 2][j] = row.charAt(j);
				if (row.charAt(j) == '@') {
					checkpointsCount++;
				}
				if (checkpointsCount > 18) {
					System.out.println("Given arguments do not satisfy specifications");
					System.exit(-1);
				}

			}
		}

		// printing input data
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(arr[i][j] + "("+i+","+j+") ");
				if (arr[i][j] == 'S') {
					start = new Square(arr[i][j], i, j);
					start.setParent(new Point(i, j));
				}
				if (arr[i][j] == 'G') {
					goal = new Square(arr[i][j], i, j);
					goal.setParent(new Point(i, j));
				}
				if (arr[i][j] == '@') {
					Square checkPoint = new Square(arr[i][j], i, j);
					checkPoint.setParent(new Point(i, j));
					checkpoints.add(checkPoint);
				}
			}
			System.out.println();
		}

		new Astar().search();
	}
}

class Square implements Comparable<Square> {
	private Point pt;
	private Point parent;
	private char val;
	private int f, g, h; // for implementing f = g + H

	public Square(char val, int x, int y) {
		this.pt = new Point(x, y);
		this.val = val;
	}

	@Override
	public int compareTo(Square o) {
		return this.f - o.f;
	}

	@Override
	public int hashCode() {
		int x = pt.getX();
		int y = pt.getY();
		
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Square sq = (Square) obj;
		return this.pt.equals(sq.pt);
	}
	
	@Override
	public String toString() {
		return "Square [pt=" + pt + ", parent=" + parent +"]";
	}

	public Point getPt() {
		return pt;
	}
	public void setPt(Point pt) {
		this.pt = pt;
	}
	public char getVal() {
		return val;
	}
	public void setVal(char val) {
		this.val = val;
	}
	public Point getParent() {
		return parent;
	}
	public void setParent(Point parent) {
		this.parent = parent;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
}

class Point {
	private int x;
	private int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point pt = (Point) obj;
		return this.x == pt.x && this.y == pt.y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 997;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
}