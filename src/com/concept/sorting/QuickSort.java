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
//			int q = partition(p, r);
/*			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");
*/
			int q = partition(arr, p, r);
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
	
	private static int partition(int arr[] ,int p ,int r){
		int pivot = arr[r];
		printArray(arr);
		System.out.println("Pivot : "+pivot +", p :"+p+", r :"+r);
		int i = p-1;
		for (int j = p; j < r; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, i, r);
		return i;
	}

	private static void swap(int arr[], int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void printArray(int arr[]){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
