package com.concept.genralprograms;

import java.util.Scanner;

public class LargestAndSmallest {
        
        public static void main(String[] args) {
        	
            Scanner sc=new Scanner(System.in);
            int n1=0, n2=0, n3=0; 
    
            System.out.println("Enter 1st number");
            n1=sc.nextInt();
            System.out.println("Enter 2nd number");
            n2=sc.nextInt();
            System.out.println("Enter 3rd number");
            n3=sc.nextInt();
            
            sc.close();

            int b = n1>=n3?(n1>=n2?n1:n2):(n2>=n3?n2:n3);
            int s = n1<=n3?(n1<=n2?n1:n2):(n2<=n3?n2:n3);
            
            System.out.println("Biggest Number is :"+b );
            System.out.println("Smallest Number is :"+s );
		}
}
