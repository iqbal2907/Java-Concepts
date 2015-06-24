package com.concept.iostream;

import java.io.File;
import java.io.IOException;

public class NormalFileCreation {

	public static void main(String[] args) {
		File file = new File(
				"/home/iqbal/practice/workspace/JavaConcepts/io_resource/myfile.txt");

		if (!file.exists()) {
			System.out.println("Creating new file :");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (file.isFile()) {
				System.out.println("file.getName() : " + file.getName());
				System.out.println("file.length() : " + file.length());
				System.out.println("file.canRead() : " + file.canRead());
				System.out.println("file.canWrite() : " + file.canWrite());
				System.out.println("file.getAbsolutePath() : " + file.getAbsolutePath());
				System.out.println("file.getPath() : " + file.getPath());
				System.out.println("file.deleteOnExit()");
				file.deleteOnExit();
				System.out.println("file.setReadOnly() : "+file.setReadOnly());
				System.out.println("file.canWrite() : "+file.canWrite());
			}
		}
	}

}
