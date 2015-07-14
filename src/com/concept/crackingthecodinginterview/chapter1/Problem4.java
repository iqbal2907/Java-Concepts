/**
 * Write a method to decide if two strings are anagrams or not.

 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem4 {

	static int[] indexArray = new int[256];

	public static void main(String[] args) {
		
		String str1 = "asdfg";
		String str2 = "fgasd";
		if (isAnagram(str1, str2)) {
			System.out.println("Its an anagram");
		} else {
			System.out.println("Not an anagram");
		}
		
	}

	private static boolean isAnagram(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			indexArray[(int)ch]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			indexArray[(int)ch]--;
		}
		for (int i = 0; i < indexArray.length; i++) {
			if (indexArray[i]!=0) {
				return false;
			}
		}
		return true;
	}
}
