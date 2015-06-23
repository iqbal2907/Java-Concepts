/**
 * The this keyword can be used to refer current class instance variable.
 * this() can be used to invoked current class constructor.
 * Call to this() must be the first statement in constructor.
 * 
 */
package com.concept.thisandsuper;

public class This1 {

	public static void main(String args[]) {
		Student13 e1 = new Student13(111, "karan");
		e1.display();

		Student13 e2 = new Student13("karan", 111);
		e2.display();

	}
}

// Program of this() constructor call (constructor chaining)

class Student13 {
	int id;
	String name;
	Student13() {
		System.out.println("default constructor is invoked");
	}

	Student13(int id, String name) {
		this();// it is used to invoked current class constructor.
		this.id = id;
		this.name = name;
	}

	Student13(String name, int id) {
		this(id, name);
	}

	void display() {
		System.out.println(id + " " + name);
	}

}