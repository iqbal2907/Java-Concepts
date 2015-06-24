package com.concept.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_FIS_FOS {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/home/iqbal/practice/workspace/JavaConcepts/io_resource/readfromfile.txt");
			FileOutputStream fos = new FileOutputStream("/home/iqbal/practice/workspace/JavaConcepts/io_resource/copyofreadfromfile.txt"); 
			
			int i=0;
			while ((i=fis.read())!=-1) {
				fos.write((char)i);
			}
			System.out.println(fis);
			System.out.println(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
