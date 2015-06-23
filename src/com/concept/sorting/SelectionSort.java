package com.concept.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {4, 5, 9, 1, 3, 0, 5, 7, 6, 1};
		selectionSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			System.out.println("min is : "+min);
			for (int j = i + 1; j < arr.length; j++) {
				if (min < arr[j]) {
					int temp = min;
					min = arr[j];
					arr[j] = temp;
					System.out.println("new min is : "+min);
				}
			}
			arr[i] = min;
		}
	}

}
