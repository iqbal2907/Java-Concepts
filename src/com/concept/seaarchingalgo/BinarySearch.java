package com.concept.seaarchingalgo;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
//		int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 13, 14};
		int[] sortedArray = {1, 3, 5, 7, 9, 11, 15, 13};
		Arrays.sort(sortedArray);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		int index = new BinarySearch().binarySearch(sortedArray, 15);
		System.out.println("\nindex : " + index);
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
	
	int recursiveBinarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (arr[mid] > x)
               return recursiveBinarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present
            // in right subarray
            return recursiveBinarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present
        //  in array
        return -1;
    }
}
