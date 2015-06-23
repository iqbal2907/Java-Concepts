/**
 * Reading data from file is a two step process
 * 1. Create FileInputStream class object by using its constructor.
 * 2. Call read() method.
 * 
 */
package com.concept.iostream;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile_FIS {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/readfromfile.txt");
			int i=0;
			while ((i=fis.read())!=-1) {
				System.out.print((char)i);
			}
			System.out.println("\n");
			System.out.println(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
