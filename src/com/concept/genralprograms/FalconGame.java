package com.concept.genralprograms;


public class FalconGame {

	public static void main(String[] args) {
		String s1 = "asbgdfsfchwa";
		String s2 = "aabfgsgfsdcqp";
		int step = countStep(s1,s2);
		String str = "FALCONSGAME";

		System.out.println(step+" : "+str);

		char[] arr = str.toCharArray();
		char result = winner(arr,0,step-1);
		System.out.println(result);
	}
	
	public static int countStep(String str1, String str2){
		
		int arr1[] = new int[26];
		int arr2[] = new int[26];
		char c; int step = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			c = str1.charAt(i);
			arr1[c-97]=arr1[c-97]+1;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			c = str2.charAt(i);
			arr2[c-97]=arr2[c-97]+1;
		}
		
		for (int i = 0; i < 26; i++) {
			step = step + Math.abs(arr1[i]-arr2[i]);
		}
		return step;
	}
	
	public static char winner(char[] arr, int si, int step){
		System.out.println("Input string :"+new String(arr));
		if (arr.length == 1) {
			return arr[0];
		}
		
		int ri = (si+step)%(arr.length);
		char[] temp = new char[arr.length-1];
		for (int i = 0,j=0; temp.length > j; i++,j++) {
			if (i==ri) {
				j--;
				continue;
			}
			temp[j]=arr[i];
		}
		char c = winner(temp,ri, step);
		return c;	
	}
}
