package com.concept.Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The superclass implements externalizable
 */
class Automobile2 implements Externalizable {

	/*
	 * Instead of making thse members private and adding setter and getter
	 * methods, I am just giving default access specifier. You can make them
	 * private members and add setters and getters.
	 */
	String regNo;
	String mileage;

	/*
	 * A public no-arg constructor
	 */
	public Automobile2() {
	}

	Automobile2(String rn, String m) {
		regNo = rn;
		mileage = m;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(regNo);
		out.writeObject(mileage);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		regNo = (String) in.readObject();
		mileage = (String) in.readObject();
	}

}
