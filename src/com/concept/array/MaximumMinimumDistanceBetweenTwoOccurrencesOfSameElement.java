package com.concept.array;

import java.util.HashMap;

public class MaximumMinimumDistanceBetweenTwoOccurrencesOfSameElement {

	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 1, 2, 5, 8, 8, 6, 7, 4, 2};
		int maxDistance = findMaxDistance(arr, 2);
		int minDistance = findMinDistance(arr, 2);

		maxDistance = maxDistnace(arr);
		System.out.println("maxDistance is :" + maxDistance);
		//System.out.println("minDistance is :" + minDistance);
	}

	private static int findMaxDistance(int[] arr, int i) {

		int[] indexArr = getIndexArray(arr, i);
		// printArray(indexArr);
		return indexArr[indexArr.length - 1] - indexArr[0];
	}

	private static int findMinDistance(int[] arr, int i) {

		int[] indexArr = getIndexArray(arr, i);

		printArray(indexArr);

		int min = indexArr.length;
		for (int j = 0; j < indexArr.length; j++) {
			for (int k = j + 1; k < indexArr.length; k++) {
				if ((indexArr[k] - indexArr[j]) < min) {
					min = indexArr[k] - indexArr[j];
				}
			}
		}
		return min;
	}

	private static void printArray(int[] indexArr) {
		for (int i = 0; i < indexArr.length; i++) {
			System.out.print(indexArr[i] + " ");
		}
	}

	private static int[] getIndexArray(int[] arr, int i) {
		int[] indexArr = new int[arr.length];
		int index = 0;

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == i) {
				indexArr[index++] = j;
			}
		}

		int[] indexArr2 = new int[index];
		for (int j = 0; j < index; j++) {
			indexArr2[j] = indexArr[j];
		}
		return indexArr2;
	}

	public static int maxDistnace(int[] array) {
		int maxD = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {

			if (map.get(array[i]) == null) {
				map.put(array[i], i);
			} else
				maxD = Math.max(maxD, i -  map.get(array[i]));
		}

		return maxD;
	}

}
