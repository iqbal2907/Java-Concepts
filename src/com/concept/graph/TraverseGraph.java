/**
 * The breadth first search (BFS) and the depth first search (DFS) are the two algorithms used for traversing and searching a node in a graph.
 * They can also be used to find out whether a node is reachable from a given node or not.
 */
package com.concept.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
	char data;
	public boolean visited;
	public Node(char c) {
		this.data = c;
	}
}

public class TraverseGraph {

	Node rootNode = null;
	Map<Integer, ArrayList<Node>> graph = new HashMap<Integer, ArrayList<Node>>();

	public TraverseGraph(Node rootNode, Map<Integer, ArrayList<Node>> graph) {
		this.rootNode = rootNode;
		this.graph = graph;
	}
	/**
	 * The aim of DFS algorithm is to traverse the graph in such a way that it
	 * tries to go far from the root node. Stack is used in the implementation
	 * of the depth first search.
	 */
	public void dfs() {
		// DFS uses Stack data structure
		Stack<Node> s = new Stack<Node>();
		s.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!s.isEmpty()) {
			Node n = s.peek();
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
	}

	/**
	 * This is a very different approach for traversing the graph nodes. The aim
	 * of BFS algorithm is to traverse the graph as close as possible to the
	 * root node. Queue is used in the implementation of the breadth first
	 * search.
	 */
	public void bfs() {
		// BFS uses Queue data structure
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = q.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		// clearNodes();
	}
	private Node getUnvisitedChildNode(Node n) {
		ArrayList<Node> list = graph.get(n.hashCode());
		Iterator<Node> itr = list.listIterator();
		while (itr.hasNext()) {
			Node node = itr.next();
			if (!node.visited) {
				node.visited = true;
				return node;
			}
		}
		return null;
	}
	private void printNode(Node rootNode2) {
		System.out.print(rootNode2.data + " ");
	}

	public static void main(String[] args) {
		Map<Integer, ArrayList<Node>> graph = new HashMap<Integer, ArrayList<Node>>();

		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		Node f = new Node('F');

		ArrayList<Node> aAdjacent = new ArrayList<Node>();
		aAdjacent.add(b);
		aAdjacent.add(c);
		aAdjacent.add(d);
		ArrayList<Node> bAdjacent = new ArrayList<Node>();
		bAdjacent.add(a);
		bAdjacent.add(e);
		bAdjacent.add(f);
		ArrayList<Node> cAdjacent = new ArrayList<Node>();
		cAdjacent.add(a);
		cAdjacent.add(f);
		ArrayList<Node> dAdjacent = new ArrayList<Node>();
		dAdjacent.add(a);
		ArrayList<Node> eAdjacent = new ArrayList<Node>();
		eAdjacent.add(b);
		ArrayList<Node> fAdjacent = new ArrayList<Node>();
		fAdjacent.add(b);
		fAdjacent.add(c);

		graph.put(a.hashCode(), aAdjacent);
		graph.put(b.hashCode(), bAdjacent);
		graph.put(c.hashCode(), cAdjacent);
		graph.put(d.hashCode(), dAdjacent);
		graph.put(e.hashCode(), eAdjacent);
		graph.put(f.hashCode(), fAdjacent);

		System.out.println(graph);
		TraverseGraph traverseGraph = new TraverseGraph(a, graph);
		traverseGraph.bfs();

	}

}
