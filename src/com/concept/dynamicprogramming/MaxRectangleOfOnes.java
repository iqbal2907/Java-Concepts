package com.concept.dynamicprogramming;

public class MaxRectangleOfOnes {

	public static void main(String[] args) {
		int[][] inputArray = {{1,0,1,1,1,1,1,1},{1,0,1,1,1,0,1,1},{1,0,1,1,1,1,1,1},{1,0,1,0,1,1,1,1}};
		int[] temp = {0,0,0,0,0,0,0,0};
		System.out.println(inputArray.length);
		System.out.println(temp.length);
		
		for (int i = 0; i < inputArray.length; i++) {
			int[] arr = inputArray[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 0) {
					temp[j] = 0;
				} else {
					temp[j] += arr[j]; 
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]+" ");
		}
	}
}
