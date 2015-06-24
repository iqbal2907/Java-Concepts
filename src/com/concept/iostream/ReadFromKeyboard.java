/**
 * LIMITATION : read() method can read one byte at a time.
 */
package com.concept.iostream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

	public static void main(String[] args) throws IOException {
		readOneLine();
		readOneChar();
		addNumbers();
	}

	private static void readOneLine() throws IOException {
		// to read one line
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Write Line : ");
		String line = br.readLine();
		System.out.println("Your line is : "+line);		
	}

	private static void readOneChar() throws IOException {
		// to read single character
		System.out.println("Enter data : ");
		int data = System.in.read();
		System.out.println("You entered : "+ (char)data);		
	}
	
	private static void addNumbers() throws IOException {
		// to read one line
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter First Number : ");
		String first = br.readLine();
		System.out.println("Enter second Number : ");
		String second = br.readLine();
		
		int result = Integer.parseInt(first)+Integer.parseInt(second);
		System.out.println("Sum is : "+result);		
	}
}
