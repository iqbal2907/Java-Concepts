package com.concept.genralprograms;

public class BinaryAddition {

	public static void main(String[] args) {

		System.out.println(binaryToInt(AddBinary(intToBinary(16), intToBinary(16))));

		String firstNo =  "10001";
		String secongNo = "1000";
		String result = AddBinary2(firstNo, secongNo);
		System.out.println(result);

		}

	private static int binaryToInt(String binary) {
		int x = 0;
		for (int i = binary.length()-1; i >= 0; i--) {
			x =  x + ((int)binary.charAt(i)-48)*(int)Math.pow(2, binary.length()-1-i);
		}
		return x;
	}

	private static String intToBinary(int i) {
		String result = "";
		while (i>0) {
			result = result.concat(i%2+"");
			i=i/2;			
		}
		result = new StringBuffer(result).reverse().toString();
		return result;
	}

	//it will give correct result for binary strings of same length 
	private static String AddBinary(String firstNo, String secongNo) {

		String result = "";
		int rem = 0;
		int len = firstNo.length() < secongNo.length() ? firstNo.length() : secongNo.length();
		
		for (int i = len - 1; i >= 0; i--) {
			int sum = (int) firstNo.charAt(i) - 48 + (int) secongNo.charAt(i) - 48 + rem;
			if (sum>1) {
				result = result.concat(sum % 2+"");
				rem = 1;
			} else {
				result = result.concat(sum % 2+"");
				rem = 0;
			}
		}
		if (rem==1) {
			result = result.concat(rem+"");
		}
		result = new StringBuffer(result).reverse().toString();
		return result;
	}
	
	private static String AddBinary2(String firstNo, String secongNo) {
		
		int sum=0,carry=0,l1=0,l2=0;
		StringBuilder sb = new StringBuilder();
		
		l1 = firstNo.length()-1;
		l2 = secongNo.length()-1;
		
		while (l1>=0 || l2>=0) {
			sum = carry;
			if(l1>=0){
				sum = sum + firstNo.charAt(l1)-'0';
				l1--;
			}
			if(l2>=0){
				sum = sum + secongNo.charAt(l2)-'0';
				l2--;
			}
			carry = sum >> 1;
			sum = sum & 1;
			sb.append(sum==0?'0':'1');
		}
		if (carry==1) {
			sb.append('1');
		}
		sb.reverse();
		return String.valueOf(sb);	
	}
}
