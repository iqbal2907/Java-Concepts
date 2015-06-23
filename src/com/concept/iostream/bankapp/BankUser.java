package com.concept.iostream.bankapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BankUser {

	public static void main(String[] args) {
		//create OIS object
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/bankaccountinfo.ser"));

			Bank accDetail = (Bank) ois.readObject();
			System.out.println(accDetail.getAccHName()+"'s Account Details : ");
			System.out.println(accDetail);
			
			System.out.println(ois);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
