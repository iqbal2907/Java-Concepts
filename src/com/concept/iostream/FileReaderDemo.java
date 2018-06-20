/**
 * LIMITATION : Using FileReader read() method cannot read one line at a time, we can read only one character at a time.
 */

package com.concept.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws FileNotFoundException {
		
		String url = FileReaderDemo.class.getResource("filereader.txt").toString();
		String str = url.split(":")[2];
		System.out.println(str);
		FileReader fr = new FileReader(str);
		int data = 0;
		int i = 0;
		int g = 1;
		char[] word = new char[20];
		char c;
		try {
			while ((data = fr.read()) != -1) {
				c = (char)data;
				if (c!=' ') {
					word[i] = c;
					i++;
				}else{
					System.out.println(new String(word).trim());
					word = new char[20];
					for (int j = 0; j < g; j++) {
						System.out.print(" ");
					}
					i=0;
				}
				g++;
			}
			System.out.println(new String(word).trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
