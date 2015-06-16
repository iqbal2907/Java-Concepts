/**
 * We can pass the this keyword in the constructor also. It is useful if we have to use one object in multiple classes. 
 * Let's see the example:
 */
package com.concept.genralprograms;

public class This4 {
	public static void main(String args[]) {
		A5 a = new A5();
	}
}
class B1 {
	A5 obj;
	B1(A5 obj) {
		this.obj = obj;
	}
	void display() {
		System.out.println(obj.data);// using data member of A4 class
	}
}

class A5 {
	int data = 100;
	A5() {
		B1 b = new B1(this);
		b.display();
	}
}