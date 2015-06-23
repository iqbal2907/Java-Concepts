package com.concept.iostream.bankapp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BankTransaction {
	
	public static void main(String[] args) {
		Bank acc1 = new Bank();
		
		acc1.setAccHName("iqbal");
		acc1.setAccNo(0123l);
		acc1.setBalance(100000);
		acc1.setUserName("iqbal123");
		acc1.setPassword("12345");
		
		System.out.println(acc1);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/bankaccountinfo.ser"));
			oos.writeObject(acc1);
			System.out.println("Object written to file");
			System.out.println(oos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
