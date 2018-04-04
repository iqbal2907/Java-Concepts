package com.concept.tree;

class Node {

	int data;
	Node left,right;
	
	Node(int i){
		data = i;
		left=right=null;
	}
}

class BinaryTree {
	Node root;
	
	private void preorder(Node root){
		if (root==null) {
			return;
		}
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	private void inorder(Node root){
		if (root==null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	private void postorder(Node root){
		if (root==null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void preOrder(){
		preorder(root);
	}

	public void inOrder(){
		inorder(root);
	}

	public void postOrder(){
		postorder(root);
	}

}

public class BinaryTreeTraversal {
	
	public static void main(String[] args) {
		BinaryTree btt = new BinaryTree();
		btt.root = new Node(1);
		btt.root.left = new Node(2);
		btt.root.right = new Node(3);
		btt.root.left.left = new Node(4);
		btt.root.left.right = new Node(5);
		btt.root.right.left = new Node(6);
		btt.root.right.right = new Node(7);

		System.out.println("\nPreorder : ");
		btt.preOrder();
		System.out.println("\nInorder : ");
		btt.inOrder();
		System.out.println("\nPostorder : ");
		btt.postOrder();
	}
}