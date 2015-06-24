package com.concept.iostream;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
//		listFiles(new File("/home/iqbal/practice/workspace/JavaConcepts/io_resource"));
		String ext = ".txt";
		findFileWithExtension(ext);
	}

	private static void findFileWithExtension(String ext) {
		
		File fileList[] = new File("/home/iqbal/practice/workspace/JavaConcepts/io_resource").listFiles();
		System.out.println("Files found with extension "+ext+" are :");
		int count = 1;
		for (int i = 0; i < fileList.length; i++) {
			File f = fileList[i];
			if (f.isFile() && f.getName().contains(ext)) {
				System.out.println(count+++" : "+f.getName());
			}
		}

	}

	private static void listFiles(File file) {

		if (file!=null) {
			File fileList[] = file.listFiles();
			System.out.println("Total files found in this directory is :"+fileList.length);
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (f.isFile()) {
					System.out.println((i+1)+" : "+f.getName());
				}
			}
		}
	}
}
