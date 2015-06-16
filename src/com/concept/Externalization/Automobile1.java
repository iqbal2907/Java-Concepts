package com.concept.Externalization;

public class Automobile1 {
	/*
	 * Instead of making these members private and adding setter and getter
	 * methods, I am just giving default access specifier. You can make them
	 * private members and add setters and getters.
	 */
	String regNo;
	String mileage;

	/*
	 * A public no-arg constructor
	 */
	public Automobile1() {
	}

	Automobile1(String rn, String m) {
		regNo = rn;
		mileage = m;
	}
}
