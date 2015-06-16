package com.concept.string;

public class TraversingStringCharectorWise {

	public static void main(String args[]) {
//		String str = "This is my string";
		String str = "A Z a z 0 9";
		for(int i=0;i<str.length();i++) {
			System.out.println(str.charAt(i)+" = "+(int)str.charAt(i));
		}
	}
}
