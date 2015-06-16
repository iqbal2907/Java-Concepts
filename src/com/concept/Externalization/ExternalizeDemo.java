/**
 * Source : http://www.jusfortechies.com/java/core-java/externalization.php
 */
package com.concept.Externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizeDemo {

	@SuppressWarnings("resource")
	public static void main(String args[]) {

/*		// create a Car object
		Car car = new Car("Mitsubishi", 2009);
		Car newCar = null;
*/

		// create a Car1 object
		Car1 car = new Car1("Mitsubishi", 2009);
		Car1 newCar = null;


/*		// create a Car2 object
		Car2 car = new Car2("Mitsubishi", 2009);
		Car2 newCar = null;
*/
		// serialize the car
		try {
			FileOutputStream fo = new FileOutputStream("/home/iqbal/workspace/MyImportantStuffs/io_resource/car.ser");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(car);
			so.flush();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}

		// de-serialize the Car
		try {
			FileInputStream fi = new FileInputStream("/home/iqbal/workspace/MyImportantStuffs/io_resource/car.ser");
			ObjectInputStream si = new ObjectInputStream(fi);
//			newCar = (Car) si.readObject();
			newCar = (Car1) si.readObject();
//			newCar = (Car2) si.readObject();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}

		/*
		 * Print out the original and new car information
		 */
		System.out.println("The original car is ");
		System.out.println(car);
		System.out.println("\nThe new car is ");
		System.out.println(newCar);
	}

}
