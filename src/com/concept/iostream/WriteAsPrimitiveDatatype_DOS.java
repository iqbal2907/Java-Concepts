package com.concept.iostream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteAsPrimitiveDatatype_DOS {
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("/home/iqbal/practice/workspace/JavaConcepts/io_resource/writeasprimitive.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeInt(1);
			dos.writeFloat(3.14f);
			dos.writeChar('x');
			dos.writeBoolean(true);
			dos.writeUTF("hell");
			System.out.println(dos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
