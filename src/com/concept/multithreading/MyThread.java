package com.concept.multithreading;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("run method");
	}

	public static void main(String[] args) {
		System.out.println("main method");
		MyThread mt = new MyThread();
		mt.start();
	}
}
