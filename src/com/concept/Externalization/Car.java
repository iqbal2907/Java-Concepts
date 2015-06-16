package com.concept.Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {

	String name;
	int year;

	/**
	 * mandatory public no-arg constructor
	 */
	public Car() {
		super();
	}

	Car(String n, int y) {
		name = n;
		year = y;
	}

	/**
	 * Mandatory writeExernal method.
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(year);
	}

	/**
	 * Mandatory readExternal method.
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		year = in.readInt();
	}

	/**
	 * Prints out the fields. used for testing!
	 */
	@Override
	public String toString() {
		return ("Name: " + name + "\n" + "Year: " + year);
	}
}
