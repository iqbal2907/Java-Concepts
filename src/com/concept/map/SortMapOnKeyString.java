package com.concept.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapOnKeyString {

	public static void main(String[] args) {
		//When key is String
		Map<String, String> map = new HashMap<String, String>();
		map.put("K", "Kolkatta");
		map.put("M", "Mumbai");
		map.put("D", "Delhi");
		map.put("C", "Chennai");
		map.put("H", "Hyderabad");
		map.put("B", "Bengaluru");
		map.put("P", "Pune");
		map.put("k", "kolkatta");
		map.put("m", "mumbai");
		map.put("d", "delhi");
		map.put("c", "chennai");
		map.put("h", "hyderabad");
		map.put("b", "bengaluru");
		map.put("p", "pune");
		
		System.out.println("\nMap before sorting : ");
		printMap(map); // This line may print in sorted order but its not guranteed
		Map<String, String> sortedMap = new TreeMap<String, String>(map);
		System.out.println("\nMap after sorting : ");
		printMap(sortedMap);
	}

	private static void printMap(Map<String, String> sortedMap) {
		for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
