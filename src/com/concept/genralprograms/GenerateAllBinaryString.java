package com.concept.genralprograms;

public class GenerateAllBinaryString {

	public static void main(String[] args) {
		String str = "1??0?101";
		int ct = printAll(str,0);
		System.out.println(ct);
	}

	private static int printAll(String str, int count) {

		if (!str.contains("?")) {
			System.out.println(str);
			count++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='?') {
				count = printAll(str.replaceFirst("\\?", "0"), count);
				count = printAll(str.replaceFirst("\\?", "1"), count);
			}
		}
		return count;
	}
}
