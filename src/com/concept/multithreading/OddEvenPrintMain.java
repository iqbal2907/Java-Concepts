package com.concept.multithreading;

public class OddEvenPrintMain {
	 
	boolean odd = true;
	int count = 1;
	int MAX = 20;
 
	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				if (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd Thread :" + count);
				count++;
				odd = false;
				notify();
			}
		}
	}
 
	public void printEven() {
 
		synchronized (this) {
			while (count < MAX) {
				if (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even thread :" + count);
				count++;
				odd = true;
				notify();
			}
		}
	}
 
	public static void main(String[] args) {
 
		final OddEvenPrintMain oep = new OddEvenPrintMain();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				oep.printEven();
 
			}
		});
		t1.setName("printEvenThread");
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				oep.printOdd();
 
			}
		});
		t2.setName("printOddThread");

		t1.start();
		t2.start();
 
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 
	}
}