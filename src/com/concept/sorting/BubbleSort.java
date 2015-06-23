package com.concept.sorting;

public class BubbleSort {
	
	public static void main(String[] args) {
		int arr[] = {4,5,9,1,3,0,5,6,9};
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void bubbleSort(int arr[]){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j]<arr[i]) {
					System.out.println("swaping :"+arr[i]+"&"+arr[j]);
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}
