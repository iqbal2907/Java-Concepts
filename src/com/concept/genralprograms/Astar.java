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

	List<Square> openList = new LinkedList<Square>();

	List<Square> closeList = new LinkedList<Square>();

	private static List<Square> checkpoints = new ArrayList<Square>();

	public void search() {
		Square source = start;
		Square destination = null;
		while (!checkpoints.isEmpty()) {
			destination = new Astar().getNearestCheckPoint(source);
			System.out.println(source +"->"+destination);
//			aStarSearch(source, destination);
			source = destination;
		}
		//finally pass goal node
		System.out.println(source +"->"+goal);
//		aStarSearch(source, goal);
	}
	public void aStarSearch(Square start, Square destination) {
		Square current = null;
		openList.add(start);
		while (openList.isEmpty() || current.val != 'G') {
			Collections.sort(openList);
			current = openList.get(0);
			closeList.add(current);
			if (!openList.contains(new Square(current.val,
					current.pt.getX() + 1, current.pt.getY() + 1))) {

			}
		}
	}

	public Square getNearestCheckPoint(Square start) {
		Square nearest = null;
		Square square = null;
		double d = 1000000000;
		double dis = 0;
		Iterator<Square> iterator = checkpoints.iterator();
		while (iterator.hasNext()) {
			square = (Square) iterator.next();
			dis = Math
					.sqrt(((start.pt.getX() - square.pt.getX()) * (start.pt
							.getX() - square.pt.getX()))
							+ ((start.pt.getY() - square.pt.getY()) * (start.pt
									.getY() - square.pt.getY())));
//			System.out.println("Node : " + square + " Dis : " + dis);
			if (dis <= d) {
				d = dis;
				nearest = square;
			}
		}
		checkpoints.remove(nearest);
		return nearest;
	}

	public static void main(String[] args) {

		int width = Integer.parseInt(args[0]);
		int hight = Integer.parseInt(args[1]);

		if (width > 100 || hight > 100) {
			System.out.println("Given arguments do not satisfy specifications");
			System.exit(-1);
		}
		System.out.println("\nwidth(j) : " + width + "\nhight(i) : "
				+ (hight - 2));
		System.out.println();
		char[][] arr = new char[hight][width];
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
				System.out.print(arr[i][j]);
				if (arr[i][j] == 'S') {
					start = new Square(arr[i][j], i, j);
				}
				if (arr[i][j] == 'G') {
					goal = new Square(arr[i][j], i, j);
				}
				if (arr[i][j] == '@') {
					checkpointsCount++;
					Square checkPoint = new Square(arr[i][j], i, j);
					checkpoints.add(checkPoint);
				}
			}
			System.out.println();
		}

		new Astar().search();
	}
}

class Square implements Comparable<Square> {
	public Point pt;
	public Point parent;
	public char val;
	public int F, G, H; // for implementing F = G + H

	public Square(char val, int x, int y) {
		this.pt = new Point(x, y);
		this.val = val;
	}
	@Override
	public int compareTo(Square o) {
		return this.F - o.F;
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
		return "Square [pt=" + pt + ", val=" + val + "]";
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
		Point pt = (Point) obj;
		return this.x == pt.x && this.y == pt.y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}