package com.concept.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapOnKeyInteger {

	public static void main(String[] args) {
		//When key is Integer
		Map<Integer, String> integerMap = new HashMap<Integer, String>();
		integerMap.put(9, "Nine");
		integerMap.put(7, "Seven");
		integerMap.put(1, "One");
		integerMap.put(3, "Three");
		integerMap.put(2, "Two");
		integerMap.put(5, "Five");
		integerMap.put(8, "Eight");
		integerMap.put(4, "Four");
		integerMap.put(6, "Six");

		Map<Integer, String> sortedIntegerMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
				return o2.compareTo(o1);
			}
		});
		
		sortedIntegerMap.putAll(integerMap);

		System.out.println("\nMap before sorting : ");
		printIntegerMap(integerMap); // This line may print in sorted order but its not guranteed
		System.out.println("\nMap after sorting : ");
		printIntegerMap(sortedIntegerMap);
	}


	private static void printIntegerMap(Map<Integer, String> sortedIntegerMap) {
		for (Map.Entry<Integer, String> entry : sortedIntegerMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}
}
