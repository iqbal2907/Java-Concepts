package com.concept.sorting;

public class OrderNSort_CountSort {
	
	public static void main(String[] args) {
		int arr[] = {1,0,2,2,0,0,1,1,1,0,1,0,1,2,2};
		sortInOrderN(arr);
	}

	private static void sortInOrderN(int arr[]) {
		int count[]= new int[3];
		int result[] = new int[arr.length];
		//for counting different occurrences
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		//for cumulative frequency
		for (int i = 1; i < count.length; i++) {
			count[i]=count[i-1]+count[i];
		}
		//for counting max index for each element
		for (int i = 0; i < arr.length; i++) {
			result[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		//This loop is for printing array
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
