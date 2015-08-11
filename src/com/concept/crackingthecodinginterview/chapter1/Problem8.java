/**
 * Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem8 {
	
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "lewaterbott";
		if (isSubstring(str1, str2)) {
			System.out.println("Its a correct rotation");
		} else {
			System.out.println("Its not a correct rotation");
		}
	}

	private static boolean isSubstring(String str1, String str2) {
		String temp = str1.concat(str1);
		for (int i = 0; i < temp.length()-str2.length(); i++) {
			if (temp.substring(i,i+str2.length()).equals(str2)) {
				return true;
			}
		}
		return false;
	}

}
