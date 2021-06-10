package com.concept.genralprograms;


public class Palindrom{
	
	public static void main(String[] args) {
		String str = "madam";
		System.out.println(isPalindrom(str));
	}
	
	public static boolean isPalindrom(String str) {

		int i = 0;
		int j = str.length()-1;
		
		while (i<j) {
			if (str.charAt(i)==str.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}