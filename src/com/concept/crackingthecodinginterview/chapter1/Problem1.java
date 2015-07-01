/**
 * Implement an algorithm to determine if a string has all unique characters. What if
	you can not use additional data structures?
 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem1 {

	public static boolean isUniqueChars1(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	/*
	 * following method will check uniqueness only for string with small case
	 */
	public static boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'A';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "dfgAS";
		System.out.println(Problem1.isUniqueChars1(str));
		System.out.println(Problem1.isUniqueChars2(str));
	}
}
