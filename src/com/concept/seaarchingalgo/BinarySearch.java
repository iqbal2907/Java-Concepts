package com.concept.seaarchingalgo;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 13, 14};
		Arrays.sort(sortedArray);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		int index = new BinarySearch().binarySearch(sortedArray, 15);
		System.out.println("index : " + index);
	}

	private int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < arr[mid]) {
				high = mid - 1;
			} else if (key > arr[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
