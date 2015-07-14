/**
 * Write a method to replace all spaces in a string with ‘%20’
 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem5 {

	public static void main(String[] args) {
		String str = "Hi How are you?";
		String result = replaceWith(str);
		System.out.println(str);
		System.out.println(result);
	}

	private static String replaceWith(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = str.length()-1; i > -1 ; i--) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				sb.append("02%");
			} else {
				sb.append(ch);
			}
		}
		
		return sb.reverse().toString();
	}
}
