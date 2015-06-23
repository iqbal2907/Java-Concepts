package com.concept.genralprograms;

public class AddBinaryNumbers {

	public static void main(String[] args) {
//		System.out.println(binaryAddition("100", "0011"));
		int s1 = 22222;	//"0111";
		s1 = s1 & 1;
		System.out.println(s1);
	}
	public static String binaryAddition(String s1, String s2) {
		if (s1 == null || s2 == null)
			return "";
		int first = s1.length() - 1;
		int second = s2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		
		while (first >= 0 || second >= 0) {
			int sum = carry;
			if (first >= 0) {
				sum += s1.charAt(first) - '0'; // '0'==48
				first--;
			}
			if (second >= 0) {
				sum += s2.charAt(second) - '0';
				second--;
			}
			 
			carry = sum >> 1;
			sum = sum & 1;
			sb.append(sum == 0 ? '0' : '1');
		}
		if (carry == 1)
			sb.append('1');
		sb.reverse();
		
		return String.valueOf(sb);
	}
}
