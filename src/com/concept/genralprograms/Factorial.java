package com.concept.genralprograms;

public class Factorial {

	public static void main(String[] args) {
		
		int i = 0;
		int fact = calculateFactorial(i);
		System.out.println("Total value : "+fact);
	}

	private static int calculateFactorial(int i) {	
		if (i==1 || i==0) {
			return 1;
		}	
		int res = calculateFactorial(i-1)*i;
		return res;
	}
}
