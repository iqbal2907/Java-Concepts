/**
 * 	If you declare any method as synchronized, it is known as synchronized method.

	Synchronized method is used to lock an object for any shared resource.

	When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
 */
package com.concept.synchronization.method;

//example of java synchronized method  

class MyThread1 extends Thread {
	Table t;
	MyThread1(Table t) {
		this.t = t;
	}
	public void run() {
		t.printTable(5);
	}

}
class MyThread2 extends Thread {
	Table t;
	MyThread2(Table t) {
		this.t = t;
	}
	public void run() {
		t.printTable(100);
	}
}

public class TestSynchronization2 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object
		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);
		t1.start();
		t2.start();
	}
}