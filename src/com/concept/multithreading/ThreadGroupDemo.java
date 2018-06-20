package com.concept.multithreading;

public class ThreadGroupDemo implements Runnable {
	public void run() {
		
		try {
			Thread.currentThread().sleep(25);			  
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

//		Thread.currentThread().getThreadGroup().interrupt();
		if (Thread.currentThread().getName().equals("one")) {
			Thread.currentThread().interrupt();		
		}
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		ThreadGroupDemo runnable = new ThreadGroupDemo();
		ThreadGroup tg1 = new ThreadGroup("Parent_ThreadGroup");

		Thread t1 = new Thread(tg1, runnable, "one");
		t1.start();
		Thread t2 = new Thread(tg1, runnable, "two");
		t2.start();
		Thread t3 = new Thread(tg1, runnable, "three");
		t3.start();

		System.out.println("Thread Group Name: " + tg1.getName());
		tg1.list();

	}
}