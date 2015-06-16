/**
 * An interface i.e. declared within another interface or class is known as nested interface. The nested interfaces are 
 * used to group related interfaces so that they can be easy to maintain. 
 * The nested interface must be referred by the outer interface or class. 
 * It can't be accessed directly.
 * 
 * There are given some points that should be remembered by the java programmer.
 * 1. Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
 * 2. Nested interfaces are declared static implicitely.
 */
package com.concept.innerclass;

//Example of nested interface which is declared within the interface
interface Showable {
	void show();
	interface Message {
		void msg();
	}
}

public class NestedInterface implements Showable.Message {
	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String args[]) {
		Showable.Message message = new NestedInterface();// upcasting here
		message.msg();
	}
}

// Example of nested interface which is declared within the class

class A {
	interface Message {
		void msg();
	}
}

class TestNestedInterface2 implements A.Message {
	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String args[]) {
		A.Message message = new TestNestedInterface2();// upcasting here
		message.msg();
	}
}