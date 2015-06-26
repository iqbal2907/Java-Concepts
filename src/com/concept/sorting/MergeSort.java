package com.concept.sorting;

public class MergeSort {

	static int arr[] = {1, 5, 8, 2, 4, 3, 7, 0, 6, 11, 1, 13, 22};
	private static int[] tempMergArr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	public static void main(String[] args) {

		System.out.println("Initial array is : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

		int start = 0, end = arr.length - 1;
		mergeSort(start, end);
		
		System.out.println("Final array is : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	
		
	}
	private static void mergeSort(int start, int end) {
		
/*		System.out.println("Array is : ");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
*/
		if (start<end) {
			int mid = start+(end-start)/2;
//			System.out.println("\n sorting lefthalf");
			mergeSort(start, mid);
//			System.out.println("\n sorting righthalf");
			mergeSort(mid+1, end);
//			System.out.println("\n merge called");
			merge(start,mid,end);
		}
	}

	private static void merge(int start, int mid, int end) {
//		System.out.println("start : "+start+", mid : "+mid+", end : "+end);
        for (int i = start; i <= end; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                arr[k] = tempMergArr[i];
                i++;
            } else {
                arr[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
/*        System.out.println("Array after merge : ");
        for (int k2 = start; k2 < end; k2++) {
			int val = arr[k2];
			System.out.print(val+" ");
		}
*/
    }
}
