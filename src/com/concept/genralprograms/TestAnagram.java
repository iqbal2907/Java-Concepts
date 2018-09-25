package com.concept.genralprograms;

public class TestAnagram {

	public static void main(String[] args) {
		String s1 = "teast";
		String s2 = "tseat";
		

		System.out.println("S1 : " + s1);
		System.out.println("S2 : " + s2);
		
		System.out.println("is anagram : "+testAnagram(s1,s2));

	}

	private static boolean testAnagram(String s1, String s2) {

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		if (arr1.length!=arr2.length) {
			return false;
		}
		quickSort(arr1, 0, arr1.length-1);
		quickSort(arr2, 0, arr2.length-1);
		
		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	static void quickSort(char A[], int si, int ei)
    {
        int pi;    /* Partitioning index */
        if(si < ei)
        {
            pi = partition(A, si, ei);
            quickSort(A, si, pi - 1);
            quickSort(A, pi + 1, ei);
        }
    }
	
    static int partition(char A[], int si, int ei)
    {
        char x = A[ei];
        int i = (si - 1);
        int j;
      
        for (j = si; j <= ei - 1; j++)
        {
            if(A[j] <= x)
            {
                i++;
                exchange(A, i, j);
            }
        }
        exchange (A, i+1 , ei);
        return (i + 1);
    }
    
    static void exchange(char A[],int a, int b)
    {
        char temp;
        temp = A[a];
        A[a]   = A[b];
        A[b]   = temp;
    }
}
