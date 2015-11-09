package com.concept.interfaces;

public abstract class AbstractTest {

	public abstract void run();
}

class testMain {
	public static void main(String[] args) {
		AbstractTest abtest = new AbstractTest() {
			
			@Override
			public void run() {
				System.out.println("Run executed");
			}
		};
		abtest.run();
	}
}