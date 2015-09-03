/**
 * 	Synchronized block can be used to perform synchronization on any specific resource of the method.
	Suppose you have 50 lines of code in your method, but you want to synchronize only 5 lines, you can use synchronized block.
	If you put all the codes of the method in the synchronized block, it will work same as the synchronized method.

	Points to remember for Synchronized block
	1. Synchronized block is used to lock an object for any shared resource.
	2. Scope of synchronized block is smaller than the method.

 */
package com.concept.synchronization.block;

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

public class TestSynchronizedBlock1 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object
		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);
		t1.start();
		t2.start();
	}
}