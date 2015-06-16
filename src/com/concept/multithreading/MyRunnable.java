package com.concept.multithreading;

public class MyRunnable implements Runnable {
	public static void main(String[] args) {
		System.out.println("main method");
		MyRunnable mr = new MyRunnable();
		Thread thread = new Thread(mr);
		thread.start();
		//thread.start();
		//it is never legal to call start method more than once on a same object. it leads to java.lang.IllegalThreadStateException
	}

	@Override
	public void run() {
		System.out.println("run method");
	}
}
