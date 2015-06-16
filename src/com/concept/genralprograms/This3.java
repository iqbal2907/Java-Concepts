/**
 * The this keyword can be used to invoke current class method (implicitly).
 */
package com.concept.genralprograms;

public class This3 {
	public static void main(String args[]) {
		S s1 = new S();
		s1.p();
	}
}
class S {
	void m() {
		System.out.println("method m() of class S is invoked");
	}
	void n() {
		this.m();// no need because compiler does it for you.
	}
	void p() {
		n();// complier will add this to invoke n() method as this.n()
	}
}
