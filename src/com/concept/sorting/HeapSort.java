package com.concept.sorting;

public class HeapSort {
	
	

	public static void main(String[] args) {
		int arr[] = {5, 7, 3, 9, 2, 8, 1, 10};
		System.out.println("Initial Array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		heapSort(arr);
		System.out.println("\nFinal Sorted Array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void heapSort(int[] arr) {
		buildMaxHeap(arr);
		for (int i = arr.length - 1; i > 0; --i) {
			swap(arr, 0, i);
			heapify(arr, 0);
		}
	}
	//this is correct
	private static void buildMaxHeap(int[] arr) {
		for (int i = (arr.length - 1) / 2; i >= 0; --i) {
			heapify(arr, i);
		}
	}

	//this will heapify with element at startIndex
	private static void heapify(int[] arr, int startIndex) {
		int i = startIndex;
		int maxElementIndex = -1;
		while (2 * i + 2 <= arr.length) {
			if (2*i+2 == arr.length) {
				maxElementIndex = arr[i] > arr[2*i+1] ? i : 2*i+1;
			} else {
				maxElementIndex = arr[2*i+1] > arr[2*i+2] ? 2*i+1 : 2*i+2;
			}
			if (arr[i]<=arr[maxElementIndex]) {
				swap(arr, i, maxElementIndex);
				i=maxElementIndex;
			}
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
