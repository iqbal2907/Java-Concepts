/**
 * 	If you declare any method as synchronized, it is known as synchronized method.

	Synchronized method is used to lock an object for any shared resource.

	When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
 */
package com.concept.synchronization.method;

//example of java synchronized method  

class Table2 {
	synchronized void printTable(int n) {// synchronized method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
class MyThread3 extends Thread {
	Table2 t;
	MyThread3(Table2 t) {
		this.t = t;
	}
	public void run() {
		t.printTable(5);
	}

}
class MyThread4 extends Thread {
	Table2 t;
	MyThread4(Table2 t) {
		this.t = t;
	}
	public void run() {
		t.printTable(100);
	}
}

public class TestSynchronization2 {
	public static void main(String args[]) {
		Table2 obj = new Table2();// only one object
		MyThread3 t1 = new MyThread3(obj);
		MyThread4 t2 = new MyThread4(obj);
		t1.start();
		t2.start();
	}
}