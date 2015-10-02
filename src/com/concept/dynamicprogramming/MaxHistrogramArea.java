package com.concept.dynamicprogramming;

import java.util.Stack;

public class MaxHistrogramArea {

	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 3, 1};
		int area = maxHistrogramArea(arr);
		System.out.println("AREA : " + area);
	}
	private static int maxHistrogramArea(int[] arr) {
		int maxArea = Integer.MIN_VALUE;
		int currentArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 2 && arr[i] < arr[i + 1]) {
				stack.push(i);
				System.out.println(i + " : " + stack);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					currentArea = arr[top] * i;
				} else {
					currentArea = arr[top] * (i - stack.peek() - 1);
				}
				if (currentArea > maxArea) {
					maxArea = currentArea;
				}
			}
		}
		return maxArea;
	}
}
