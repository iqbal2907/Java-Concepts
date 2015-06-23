package com.concept.iostream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadAsPrimitiveDatatype_DIS {
	
	public static void main(String[] args) {
		try {
			FileInputStream fos = new FileInputStream("/home/iqbal/practice/workspace/MyImportantStuffs/io_resource/writeasprimitive.txt");
			DataInputStream dos = new DataInputStream(fos);
			
			int i = dos.readInt();
			float f = dos.readFloat();
			char c = dos.readChar();
			boolean b = dos.readBoolean();
			String str = dos.readUTF();

			System.out.println(dos);
			System.out.println(i);
			System.out.println(f);
			System.out.println(c);
			System.out.println(b);
			System.out.println(str);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
