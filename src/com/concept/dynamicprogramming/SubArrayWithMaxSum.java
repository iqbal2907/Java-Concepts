package com.concept.dynamicprogramming;
/*
 *    Java Program to Implement Kadane Algorithm
 */
public class SubArrayWithMaxSum {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 2, 8, 9, 10, 0, 0, 0, 3, 4, 1, 10};
		int max_ending_here, max_so_far;
		max_ending_here = max_so_far = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max_ending_here < 0)
				max_ending_here = arr[i];
			else
				max_ending_here += arr[i];

			/* calculate maxSoFar */
			if (max_ending_here >= max_so_far)
				max_so_far = max_ending_here;
		}
		System.out.println("Max Sum :"+max_so_far);
	}
}
