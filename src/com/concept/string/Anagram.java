package com.concept.string;

public class Anagram {

	public static void main(String args[]) {
		String str1 = "abcdef";
		String str2 = "fedcba";
		int result = new Anagram().anagram(str1, str2);
		System.out.println(result);
	}
	
	public int anagram(String str1, String str2) {
		int result=0;
		for(int i=0;i<str1.length();i++) {
			result = result+(int)str1.charAt(i)-(int)str2.charAt(i);
		}
	return result;	
	} 
}
