/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its corresponding entire row and
   column is set to 0

 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem7 {

	public static void main(String[] args) {
		int[][] arr = {{0,2,3,7,5},{4,5,6,3,2},{7,0,9,1,8},{8,4,3,1,6},{5,3,9,1,2}};
		System.out.println("\nArray before setting to zero");
		printArray(arr);
		setRCZeroIfExist(arr);
		System.out.println("\nArray after setting to zero");
		printArray(arr);
	}

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void setRCZeroIfExist(int[][] arr) {
		int[][] temp = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					temp[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (temp[i][j] == 1) {
					setZero(arr,i,j);
				}
			}
		}
		System.out.println("\nTemp Array");
		printArray(temp);
	}

	private static void setZero(int[][] arr, int i, int j) {
		for (int p = 0; p < arr.length; p++) {
			arr[i][p] = 0;
			arr[p][j] = 0;
		}
	}
}
