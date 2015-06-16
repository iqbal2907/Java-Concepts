/**
 * The super keyword can also be used to invoke parent class method. It should be used in case subclass contains 
 * the same method as parent class as in the example given below:
 */
package com.concept.genralprograms;

public class Super3 {

	public static void main(String args[]) {
		Student16 s = new Student16();
		s.display();
	}
}
class Person {
	void message() {
		System.out.println("Person message");
	}
}
class Student16 extends Person {
	void message() {
		System.out.println("Student16 message");
	}

	void display() {
		message();// will invoke current class message() method
		super.message();// will invoke parent class message() method
	}
}

/**
 * In case there is no method in subclass as parent, there is no need to use
 * super. we can directly call message() method.
 */
