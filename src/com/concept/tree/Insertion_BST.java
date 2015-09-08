package com.concept.tree;

//This is a java program to insert elements in a Binary Search Tree
import java.util.Scanner;

class BSTNode {

	private BSTNode left;
	private BSTNode right;
	private int data;

	public BSTNode() {
		left = null;
		right = null;
		data = 0;
	}

	public BSTNode(int n) {
		left = null;
		right = null;
		data = n;
	}
	
	

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

class BSTree {
	private BSTNode root;

	public BSTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private BSTNode insert(BSTNode node, int data) {
		if (node == null)
			node = new BSTNode(data);
		else {
			if (data <= node.getData())
				node.setLeft(insert(node.getLeft(), data));
			else
				node.setRight(insert(node.getRight(), data));
		}
		return node;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(BSTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(BSTNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
}

public class Insertion_BST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BSTree bst = new BSTree();
		System.out.println("Binary Search Tree Insertion Test\n");
		int N = 10;
		for (int i = 0; i < N; i++) {
			bst.insert(scan.nextInt());
			System.out.print("\nPost order : ");
			bst.postorder();
			System.out.print("\nPre order  : ");
			bst.preorder();
			System.out.print("\nIn order   : ");
			bst.inorder();
		}
		scan.close();
	}
}
