package com.concept.sorting;

public class BubbleSort {
	
	public static void main(String[] args) {
		int arr[] = {4,5,9,1,3,0,5,6,7};
		System.out.println("arr.length is :"+arr.length);
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void bubbleSort(int arr[]){
		for (int i = arr.length-1; i >=0 ; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j]>arr[j+1]) {
					System.out.println("swaping :"+arr[j]+"&"+arr[j+1]);
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}	
}
