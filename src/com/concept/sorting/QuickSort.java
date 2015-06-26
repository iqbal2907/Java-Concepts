package com.concept.sorting;

public class QuickSort {

	static int arr[] = {1, 5, 8, 2, 4, 3, 7, 0, 6, 11, 1, 13, 22};
	public static void main(String[] args) {

		System.out.println("Initial array is : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

		int start = 0, end = arr.length - 1;
		quickSort(start, end);
		
		System.out.println("Final array is : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void quickSort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	private static int partition(int p, int r) {
		int i = p;
		int j = r;
		int pivot = arr[(i+j)/2];
		System.out.println("Pivot : "+pivot);
		System.out.println("Pivot index is : "+(i+j)/2);

		while (i<=j) {
			while (arr[i]<pivot) {
				++i;
			}
			while (arr[j]>pivot) {
				--j;
			}
			if (i<=j) {
				exchange(i, j);
				++i;
				++j;
			}
		}
		return i-1;
	}
}
