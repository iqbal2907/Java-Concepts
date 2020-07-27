package com.concept.stack;

public class MyGenericStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGenericStack<String> myGenericStack = new MyGenericStack<String>();
//		myGenericStack.print();
		myGenericStack.push("kaish");
		myGenericStack.push("khalid");
		myGenericStack.push("ashrafi");
		myGenericStack.push("basit");
		myGenericStack.push("faizan");
		System.out.println("stack size is :"+myGenericStack.size());
		System.out.println("Middle element is :"+myGenericStack.findMiddle());
		myGenericStack.print();

		String peekData = myGenericStack.peek();
		System.out.println("Peek element is :"+peekData);
		System.out.println("stack size after peek operation is :"+myGenericStack.size());
		System.out.println("\n");
		
		myGenericStack.pop();
		System.out.println("stack size after 1 pop operation is :"+myGenericStack.size());
		System.out.println("Middle element is :"+myGenericStack.findMiddle());
		myGenericStack.print();
		System.out.println("\n");

		myGenericStack.pop();
		myGenericStack.pop();
		myGenericStack.pop();
		myGenericStack.pop();
		
		System.out.println("stack size after 4 more pop operation is :"+myGenericStack.size());
		myGenericStack.print();
		
		myGenericStack.pop();
		System.out.println("stack size is :"+myGenericStack.size());
		myGenericStack.print();

		myGenericStack.push("kaish");
		myGenericStack.push("khalid");
		myGenericStack.push("ashrafi");
		myGenericStack.push("basit");
		myGenericStack.push("faizan");
		System.out.println("stack size before deleteMiddle is :"+myGenericStack.size());
		System.out.println("Deleted middle element is :"+myGenericStack.deleteMiddle());
		System.out.println("stack size after deleteMiddle is :"+myGenericStack.size());
		myGenericStack.print();
		
	}

}
