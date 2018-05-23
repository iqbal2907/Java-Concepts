package com.concept.designpattern.behavioral.command;

public interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}