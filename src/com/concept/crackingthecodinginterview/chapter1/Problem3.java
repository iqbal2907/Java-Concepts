/**
 * Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer. NOTE: One or two additional variables are fine.
An extra copy of the array is not.
FOLLOW UP
Write the test cases for this method.

 */
package com.concept.crackingthecodinginterview.chapter1;

public class Problem3 {

	public static void main(String[] args) {
//		char[] str = {'a','n','a','g','r','a','m','a'};
//		char[] str = {'a','a','a','b','b','b','b'};
		char[] str = {'a','n','a','g','r','a','a','a'};
		System.out.println("Before removing duplicates");
		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			System.out.print(c);
		}
		removeDuplicates(str);
		System.out.println("\nAfter removing duplicates");
		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			System.out.print(c);
		}
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
}
