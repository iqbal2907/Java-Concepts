package com.concept.multithreading;

class ShutdownHookThread extends Thread {
	public void run() {
		System.out.println("shut down hook task completed..");
	}
}

public class TestShutdownHook {
	public static void main(String[] args) throws Exception {

		Runtime r = Runtime.getRuntime();
		
		//using Thread class child object
//		r.addShutdownHook(new ShutdownHookThread());

		//providing anonymous class object for runnable interface as argument to Thread class object
		r.addShutdownHook(new Thread( new Runnable() {
			public void run() {
				System.out.println("shut down hook task completed..");				
			}
		}));

		System.out.println("Now main sleeping... press ctrl+c to exit");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
}
