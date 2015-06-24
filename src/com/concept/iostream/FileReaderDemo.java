/**
 * LIMITATION : Using FileReader read() method cannot read one line at a time, we can read only one character at a time.
 */

package com.concept.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("/home/iqbal/practice/workspace/JavaConcepts/io_resource/filereader.txt");
		int data = 0;
		try {
			while ((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
