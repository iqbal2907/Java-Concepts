package com.concept.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "Ashrafi Iqbal";
		e.address = "Madhapur Hyderabad";
		e.SSN = 11122333;
		e.number = 101;
		try {
			FileOutputStream fileOut = new FileOutputStream("/home/iqbal/workspace/MyImportantStuffs/io_resource/employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /home/iqbal/workspace/MyImportantStuffs/io_resource/employee.txt");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}