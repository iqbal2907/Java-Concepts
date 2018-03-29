package com.concept.genralprograms;

/** this is actually program for Narcissistic number
	The three digit integer which is the sum of the cubes of its 
	digits that is equal to the number itself. 
	like 371= 3*3*3+7*7*7+1*1*1 and is called Armstrong number.
*/

public class ArmstrongNumber {

	public static boolean isArmstrongNumber(int number){
		
		int input=number;
		int result=0;
		int facevalue=0;
		int j = numlen(input);
		for (int k=0; k<=j; k++) {
			facevalue = input%10;
			result = result+powerInt(facevalue, j);
			input = input/10;
		}
		return result==number;
	}
	
	public static int powerInt(int num, int pow){
		if (num==0) {
			return 0;
		}
		int result = 1;
		for (int i = 0; i < pow; i++) {
			result = result*num;
		}
		return result;
	}

	public static int numlen(int num){
		int j=0;
		while(num>=1){
			num=num/10;
			j++;
		}		
		return j;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			if (isArmstrongNumber(i)) {
				System.out.println(i);
			}
		}
	}
}
