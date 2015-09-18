package com.jp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SearchGame {

	static int checkpointsCount = 0;

	Map<Integer, List<CheckNode>> adjMap = new HashMap<Integer, List<CheckNode>>();
	CheckNode rootNode = null;
	
	public SearchGame() {
	}
	public SearchGame(CheckNode rootNode, Map<Integer, List<CheckNode>> adjMap) {
		this.rootNode = rootNode;
		this.adjMap = adjMap;
	}

	/**
	 * The aim of DFS algorithm is to traverse the graph in such a way that it
	 * tries to go far from the root node. Stack is used in the implementation
	 * of the depth first search.
	 */
	public void dfs() {/*
						 * // DFS uses Stack data structure //write game logic
						 * here Stack<CheckNode> s = new Stack<CheckNode>();
						 * s.push(this.rootNode);
						 * System.out.println("ROOT : "+rootNode.getVal());
						 * this.rootNode.visited = true; while (!s.isEmpty()) {
						 * CheckNode n = s.peek(); CheckNode child =
						 * getUnvisitedChildNode(n); if (child != null) {
						 * child.visited = true;
						 * System.out.print(child.getVal()+" "); s.push(child);
						 * } else { s.pop(); } }
						 */
		// BFS uses Queue data structure
		Queue<CheckNode> q = new LinkedList<CheckNode>();
		q.add(this.rootNode);
		rootNode.visited = true;
		System.out.println("ROOT : " + rootNode);
		while (!q.isEmpty()) {
			CheckNode n = q.remove();
			CheckNode child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				System.out.print(child+"->");
				q.add(child);
			}
		}
	}

	private CheckNode getUnvisitedChildNode(CheckNode n) {

		ArrayList<CheckNode> list = (ArrayList<CheckNode>) adjMap.get(n
				.getHashValue());
		Iterator<CheckNode> itr = list.listIterator();
		while (itr.hasNext()) {
			CheckNode node = itr.next();
			if (!node.visited) {
				node.visited = true;
				return node;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int width = Integer.parseInt(args[0]);
		int hight = Integer.parseInt(args[1]);
		
		if (width>100 || hight>100) {
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
			}
		}
		
		if (checkpointsCount>18) {
			System.out.println("Given arguments do not satisfy specifications");
			System.exit(-1);
		}
		// printing input data
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// creating object map
		Map<Integer, CheckNode> objMap = new HashMap<Integer, CheckNode>();
		for (int i = 1; i < hight - 1; i++) {
			for (int j = 1; j < width - 1; j++) {
				CheckNode node = new CheckNode(i, j, arr[i][j]);
				node.setHashValue(node.hashCode());
				objMap.put(node.hashCode(), node);
			}
		}

		CheckNode rootNode = null;
		Map<Integer, List<CheckNode>> adjMap = new HashMap<Integer, List<CheckNode>>();

		hight = hight - 2;
		for (int i = 1; i < hight - 1; i++) {
			for (int j = 1; j < width - 1; j++) {
				if (arr[i][j] != '#') {
					CheckNode node = new CheckNode(i, j, arr[i][j]);
					if (arr[i][j] == 'S') {
						rootNode = node;
						rootNode.setHashValue(node.hashCode());
					}

					List<CheckNode> list = new ArrayList<CheckNode>(8);
					// prepare adjacency list here
					if (arr[i - 1][j] != '#') {
						CheckNode nd = new CheckNode(i - 1, j, arr[i - 1][j]);
						nd.setHashValue(nd.hashCode());
						list.add(objMap.get(nd.hashCode()));
					}
					if (arr[i][j - 1] != '#') {
						CheckNode nd = new CheckNode(i, j - 1, arr[i][j - 1]);
						nd.setHashValue(nd.hashCode());
						list.add(objMap.get(nd.hashCode()));
					}
					if (arr[i + 1][j] != '#') {
						CheckNode nd = new CheckNode(i + 1, j, arr[i + 1][j]);
						nd.setHashValue(nd.hashCode());
						list.add(objMap.get(nd.hashCode()));
					}
					if (arr[i][j + 1] != '#') {
						CheckNode nd = new CheckNode(i, j + 1, arr[i][j + 1]);
						nd.setHashValue(nd.hashCode());
						list.add(objMap.get(nd.hashCode()));
					}
					adjMap.put(node.hashCode(), list);
				}
			}
		}

		System.out.println("total no of checkpoints : " + checkpointsCount);
		System.out.println("ROOT in main : " + rootNode);
		System.out.println(adjMap);
		new SearchGame(rootNode, adjMap).dfs();

	}
}

class CheckNode {
	private int x;
	private int y;
	private char val;
	public boolean visited;
	public int hashValue;

	CheckNode() {
	}
	CheckNode(int x, int y, char val) {
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
	public char getVal() {
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
		result = prime * result + val;
		result = prime * result + (visited ? 1231 : 1237);
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

}