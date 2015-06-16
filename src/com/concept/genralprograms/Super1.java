/**
 * 
 * The super keyword in java is a reference variable that is used to refer immediate parent class object. 
 * Whenever you create the instance of subclass, an instance of parent class is created implicitly 
 * i.e. referred by super reference variable
 * 
 * Usage of java super Keyword
 * 1. super is used to refer immediate parent class instance variable.
 * 2. super() is used to invoke immediate parent class constructor.
 * 3. super is used to invoke immediate parent class method.
 */
package com.concept.genralprograms;

public class Super1 {
	public static void main(String args[]) {
		Bike4 b = new Bike4();
		b.display();
	}
}

class Vehicle {
	int speed = 50;
}

class Bike4 extends Vehicle {
	int speed = 100;

	void display() {
		System.out.println(super.speed);// super is a non static reference to super class object
	}
}