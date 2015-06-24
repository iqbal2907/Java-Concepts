/**
 * NOTE : write() method of FileOutputStream converts given data into ASCII character but print() and println() doesn't convert. 
 * 
 */
package com.concept.iostream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class StoringDataInFileUsingPrintStream {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("/home/iqbal/practice/workspace/JavaConcepts/io_resource/printstream.txt");
		ps.print('a');
		ps.print("Hello");
		ps.println('A');
		ps.println("world");
		ps.println();
		ps.append("appended part");
		System.out.println(ps);
	}
}
