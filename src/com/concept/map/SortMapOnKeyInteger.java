package com.concept.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.AbstractDocument.BranchElement;

public class SortMapOnKeyInteger {

	public static void main(String[] args) {
		int i = 0;
		for (; ;) {
			for (i = 0; i <=5; i++) {
				System.out.println(i);
			}
			if (i>5) {
				break;
			}
		}
	}


	private static void printIntegerMap(Map<Integer, String> sortedIntegerMap) {
		for (Map.Entry<Integer, String> entry : sortedIntegerMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}
}
