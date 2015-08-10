package com.concept.genralprograms;

public class ElliminateDuplicateFromString {
	
	public static void main(String[] args) {
		String str = "remove duplicates from this string";
//		String result = removeDuplicateOccurances(str);
		String result = removeDuplicateOrderMaintained(str);
		System.out.println(str+"\t: Original String");
		System.out.println(result+"\t\t\t: String after duplicate elimination");
	}

	// Using extra space (Hashing technique)
	private static String removeDuplicateOccurances(String str) {
		StringBuffer result = new StringBuffer();
		int[] hash = new int[256];
		for (int i = 0; i < str.length(); i++) {
			hash[str.charAt(i)]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i]!=0) {
				result.append((char)i);
			}
		}
		return result.toString();
	}
	//Inplace elimination using extra space and maintaining order
	private static String removeDuplicateOrderMaintained(String str) {
		StringBuffer result = new StringBuffer();
		int[] hash = new int[256];
		for (int i = 0; i < str.length(); i++) {
			if (hash[str.charAt(i)]==0) {
				hash[str.charAt(i)]++;
				result.append(str.charAt(i));
			}
		}
		return result.toString();
	}
}
