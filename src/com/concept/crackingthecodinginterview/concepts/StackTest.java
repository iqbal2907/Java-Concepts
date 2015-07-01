package com.concept.crackingthecodinginterview.concepts;

import java.util.ArrayList;

public class StackTest {

	public static void main(String[] args) {
		GenericStack<Integer> stack = new GenericStack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		GenericStack<String> stringStack = new GenericStack<String>("a");
		stringStack.push("b");
		stringStack.push("c");
		stringStack.push("d");
		stringStack.push("e");

		GenericStack<Character> charStack = new GenericStack<Character>('a');
		charStack.push('b');
		charStack.push('c');
		charStack.push('d');
		charStack.push('e');

/*		GenericStack<Integer> stk = null;
		stack.print(stk);

		GenericStack<Integer> stack = new GenericStack<Integer>(1);
		stack.print(stack);
*/

		stack.print(stack);
//		System.out.println(stack.pop());
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
	}
}
