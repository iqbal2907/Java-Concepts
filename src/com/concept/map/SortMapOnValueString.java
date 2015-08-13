package com.concept.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapOnValueString {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "A");
		map.put(1, "B");
		map.put(2, "C");
		map.put(3, "X");
		map.put(4, "Y");
		map.put(5, "Z");
		map.put(6, "P");
		map.put(7, "Q");
		map.put(8, "R");
		map.put(9, "a");
		map.put(10, "b");
		map.put(11, "c");
		map.put(12, "x");
		map.put(13, "y");
		map.put(14, "z");
		map.put(15, "p");
		map.put(16, "q");
		map.put(17, "r");
		map.put(18, "s");
		map.put(19, "t");
		map.put(20, "u");

		System.out.println("Map before sorting on value :  "+map);

		ArrayList<Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>();
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			list.add(entry);
		}
		System.out.println("List before sorting on value : "+list);
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		System.out.println("List after sorting on value :  "+list);
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		Iterator<Entry<Integer, String>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("Map after sorting on value :   "+sortedMap);
	}
}
