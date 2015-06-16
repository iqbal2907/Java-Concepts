package com.concept.genralprograms;

public class StaticBlock {
	static {
		System.out.println("Static block");		
	}
	static int i = test();
	static int test(){
		System.out.println("Hello World");
		return 0;
	}

	public static void main(String[] args) {
		
	}
}
