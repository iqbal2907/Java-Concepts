/**
 * The isInterrupted() method returns the interrupted flag either true or false. The static interrupted() method returns the interrupted 
 * flag afterthat it sets the flag to false if it is true.
 */
package com.concept.synchronization.interruptingthread;

public class InterruptingThread4 extends Thread {

	public void run() {
		for (int i = 1; i <= 2; i++) {
			if (Thread.interrupted()) {
				System.out.println("code for interrupted thread");
			} else {
				System.out.println("code for normal thread");
			}

		}// end of for loop
	}

	public static void main(String args[]) {

		InterruptingThread4 t1 = new InterruptingThread4();
		InterruptingThread4 t2 = new InterruptingThread4();

		t1.start();
		t1.interrupt();

		t2.start();

	}
}