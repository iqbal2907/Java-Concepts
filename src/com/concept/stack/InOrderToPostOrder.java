package com.concept.stack;

import java.util.Iterator;
import java.util.Stack;

public class InOrderToPostOrder {

	Stack<Character> stack = new Stack<Character>();
	
	String convertToPostOrderFromInOrder(String input){
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			if (48<=ch&&ch<=57) {
				
			}
		}
		return output;
	}
}
