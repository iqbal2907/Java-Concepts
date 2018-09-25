package com.concept.multithreading;

public class printOddEven {

	public static void main(String[] args) {

		final OddEven oe = new OddEven();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				oe.printOdd();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				oe.printEven();
			}
		});

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

class OddEven {

	public int count = 20;
	public int temp = 1;
	public boolean odd = true;

	public void printOdd() {

		synchronized (this) {
			while (temp < count) {
				if (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(temp);
				temp++;
				odd = false;
				notify();
			}
		}
	}

	public void printEven() {

		synchronized (this) {
			while (temp < count) {
				if (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(temp);
				temp++;
				odd = true;
				notify();

			}
		}
	}
}
