package com.concept.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataToFile_FOS {

	public static void main(String[] args) {
		try {
			byte b[] = {'x','y','z','p','q','r'};
			FileOutputStream fos = new FileOutputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/writeinthisfile.txt");
			fos.write('a');
			fos.write('b');
			fos.write('c');
			
			fos.write(b);
			
			fos.write(3);
			
			fos.write(b, 3, 3);
			//to append data in file
			FileOutputStream fos2 = new FileOutputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/writeinthisfile.txt",true);
			byte b2[] = {'1','2','3'};
			fos2.write(b2);
			System.out.println(fos);
			System.out.println(fos2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
