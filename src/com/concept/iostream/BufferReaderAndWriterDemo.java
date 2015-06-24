/**
 * Using BufferedReader object we cant read a line from keyboard since it doesn't have any InputStream parameter constructor
 */
package com.concept.iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderAndWriterDemo {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/iqbal/practice/workspace/JavaConcepts/io_resource/bufferedreaderwriter.txt"));
			String line = "";
			int i = 1;
			while ((line = br.readLine()) != null) {
				System.out.println(i+" line is : "+line);
				i++;
			}
			System.out.println(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
