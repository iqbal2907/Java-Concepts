package com.concept.interfaces;
interface InterfaceTest {
	void greet();
	void warn();
}

public class InterfaceObject {

	public static void main(String[] args) {
		InterfaceTest t = new InterfaceTest() {
			public void greet() {
				System.out.print("\nHi, Best wishes to way2java.com\n");
			}

			public void warn() {
				// TODO Auto-generated method stub
				System.out.println("This is warning");
			}
		};
		t.greet();
		t.warn();
	}

}
