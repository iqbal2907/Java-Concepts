package com.concept.tree.gfg.genral;

public class TestTree {

	TNode root;
	static Vlength verticalLength = new Vlength();
	
	public static void main(String[] args) {
		TestTree tt = new TestTree();
		tt.root = new TNode(0);
		tt.root.left = new TNode(1);
		tt.root.right = new TNode(2);
		tt.root.left.left = new TNode(3);
		tt.root.left.right = new TNode(4);
		tt.root.right.left = new TNode(5);
		tt.root.right.right = new TNode(6);
		tt.root.left.left.left = new TNode(7);
		tt.root.left.left.right = new TNode(8);
		tt.root.left.left.right.left = new TNode(9);
		tt.root.left.left.right.left.left = new TNode(10);
		tt.root.left.left.right.left.left.left = new TNode(11);
		
//		printTree(tt.root);
		printVertical(tt.root);
		
		
	}
	
	private static void printVertical(TNode root) {
		
		if (root == null) {
			return;
		}

		CalculateVDistanceFromRoot(root, verticalLength, 0);
//		System.out.println("verticalLengthMin : "+verticalLength.min+",  verticalLengthMax : "+verticalLength.max);

		int ivl = 0;
		for (int vl = verticalLength.min; vl <= verticalLength.max; vl++) {
			printVertically(root,vl,ivl);
			System.out.println();
		}
	}

	private static void printVertically(TNode root, int vl, int ivl) {

		if (root==null) {
			return;
		}
		
		if (vl == ivl) {
			System.out.print(root.data+" ");
		}
		printVertically(root.left, vl, ivl-1);
		printVertically(root.right, vl, ivl+1);
	}
	

	private static void CalculateVDistanceFromRoot(TNode root,
			Vlength verticalLength, int ivl) {

		if (root==null) {
			return;
		}

//		System.out.println("Data : "+root.data+"  Min : "+verticalLength.min+",  Max : "+verticalLength.max);

		if (ivl < verticalLength.min) {
			verticalLength.min = ivl;
		}
		if (ivl > verticalLength.max) {
			verticalLength.max = ivl;
		}
		
		CalculateVDistanceFromRoot(root.left, verticalLength, ivl-1);
		CalculateVDistanceFromRoot(root.right, verticalLength, ivl+1);
	}

	private static void printTree(TNode root) {
		
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);

	}
}

class TNode {
	int data;
	TNode left;
	TNode right;
	
	TNode(int data) {
		this.data=data;
		left = right = null;
	}
}

class Vlength {
	int min;
	int max;
}