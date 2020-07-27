package com.concept.queue;

public class MyGenericQueueTest {
	public static void main(String[] args) {
		MyGenericQueue<String> myGenericQueue = new MyGenericQueue<String>();
		myGenericQueue.print();
		myGenericQueue.add("A");
		myGenericQueue.add("B");
		myGenericQueue.add("C");
		myGenericQueue.add("D");
		myGenericQueue.print();
		System.out.println("Queue peek = "+myGenericQueue.peek());
		System.out.println("Queue size = "+myGenericQueue.size());
		System.out.println("Removing one element ...");
		myGenericQueue.remove();
		myGenericQueue.print();
		System.out.println("Adding one element ...");
		myGenericQueue.add("E");
		System.out.println("Queue size = "+myGenericQueue.size());
		myGenericQueue.print();
		
	}
}
