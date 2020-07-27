package com.concept.crackingthecodinginterview.concepts;

public class GenericStackTest {

	public static void main(String[] args) {
		
		System.out.println("\nStack of Integers :");

		GenericStack<Integer> stack = new GenericStack<Integer>(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.print(stack);
		stack.pop();
		System.out.println("\nStack after 1st pop() call :");
		stack.print(stack);
		
		System.out.println("\nStack of Strings :");

		GenericStack<String> stringStack = new GenericStack<String>("abc");
		stringStack.push("bcd");
		stringStack.push("cde");
		stringStack.push("def");
		stringStack.push("efg");
		stringStack.print(stringStack);
		stringStack.pop();
		System.out.println("\nStack after 1st pop() call :");
		stringStack.print(stringStack);
		
		System.out.println("\nStack of Characters :");


		
		
	}
}
