package com.concept.sorting;

public class InsertionSort {
	
	public static void main(String[] args) {
		int arr[] = {4, 5, 9, 1, 3, 0, 5, 7, 6, 9};
		insertionSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void insertionSort(int arr[]){
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j]<arr[j-1]) {
					System.out.println("swaping :"+arr[j]+"&"+arr[j-1]);
					int temp = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}

}
