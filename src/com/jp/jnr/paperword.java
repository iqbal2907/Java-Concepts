package com.jp.jnr;

import java.util.Scanner;

class paperword 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The No Of Fold");
		int n = sc.nextInt();
		String M = "V";
		String str = "V";
		String rev = "";
		if(n == 0){
			System.out.println(" ");
		}else if(n == 1){
			System.out.println(str);
		}else{
			for(int i=1;i<n;i++){
				rev = reverse(str);
				str = M.concat(str);
				str = rev.concat(str);
			}
		}
		System.out.println(str);
	}
	public static String reverse(String str){
		String rev = "";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == 'V')
				rev = rev.trim()+'A';
			else
				rev = rev.trim()+'V';
		}
		StringBuffer sb = new StringBuffer(rev);
		sb.reverse();
		rev = sb.toString();
	return rev;
	}
}
