/**
 * As we know well that default constructor is provided by compiler automatically but it also adds super() 
 * for the first statement.If you are creating your own constructor and you don't have either this() or super() 
 * as the first statement, compiler will provide super() as the first statement of the constructor.
 * 
 * The super keyword can also be used to invoke the parent class constructor as given below:
 */
package com.concept.thisandsuper;

public class Super2 {

	public static void main(String args[]) {
		Bike5 b1 = new Bike5();
		Bike5 b2 = new Bike5("BMW");
	}

}
class Vehicle2 {
	Vehicle2() {
		System.out.println("Vehicle is created");
	}
	Vehicle2(String name) {
		System.out.println("Vehicle name is :"+name);
	}
}

class Bike5 extends Vehicle2 {
	Bike5() {
		super();// will invoke parent class constructor
		System.out.println("Bike is created");
	}
	Bike5(String name) {
		super(name);// will invoke parent class constructor
		System.out.println("Bike is created");
	}
}






