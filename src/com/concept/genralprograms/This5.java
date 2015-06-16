/**
 * We can return the this keyword as an statement from the method. In such case, return type of the method must be 
 * the class type (non-primitive). Let's see the example:
 */
package com.concept.genralprograms;

public class This5 {
	public static void main(String args[]) {
		new A().getA().msg();
		
		//prove that this keyword refers to the current class
		A6 obj = new A6();
		System.out.println(obj);// prints the reference ID

		obj.m();

	}
}

class A {
	A getA() {
		return this;
	}
	void msg() {
		System.out.println("Hello java");
	}
}
/**
 * Let's prove that this keyword refers to the current class instance variable. In this program, 
 * we are printing the reference variable and this, output of both variables are same.
 */
class A6 {
	void m() {
		System.out.println(this);// prints same reference ID
	}
}