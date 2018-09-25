package com.concept.tree.gfg.bst;

//Java program to demonstrate insert operation in binary search tree
public class BinarySearchTree {

	/* Class containing left and right child of current node and key value */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	
	// This method mainly calls preOrderRec()
	void preOrder() {
		preOrderRec(root);
	}

	// A utility function to do preOrder traversal of BST
	void preOrderRec(Node root) {
		if (root != null) {
			System.out.println(root.key);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	
	// This method mainly calls postOrderRec()
	void postOrder() {
		postOrderRec(root);
	}

	// A utility function to do postOrder traversal of BST
	void postOrderRec(Node root) {
		if (root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.println(root.key);
		}
	}

	// A utility function to search a given key in BST
	public Node search(Node root, int key)
	{
	    // Base Cases: root is null or key is present at root
	    if (root==null || root.key==key)
	        return root;
	 
	    // val is greater than root's key
	    if (root.key > key)
	        return search(root.left, key);
	 
	    // val is less than root's key
	    return search(root.right, key);
	}
	
	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		/*
		 * Let us create following BST 
		 * 
		 * 
		 * 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("inorder traversal of the BST :");
		// print inorder traversal of the BST
		tree.inorder();

		System.out.println("preOrder traversal of the BST :");
		// print preOrder traversal of the BST
		tree.preOrder();

		System.out.println("postOrder traversal of the BST :");
		// print postOrder traversal of the BST
		tree.postOrder();

	}
}
