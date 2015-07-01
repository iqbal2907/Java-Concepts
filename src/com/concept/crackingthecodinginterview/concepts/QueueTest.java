package com.concept.crackingthecodinginterview.concepts;

public class QueueTest {

	public static void main(String[] args) {
		GenericQueue<Integer> queue = new GenericQueue<Integer>(1);
		queue.enqueue(2);
		queue.enqueue(3);



		System.out.println("Queue before dequeue");
		queue.print(queue);

		System.out.println("Dequeued element is : "+queue.dequeue());

		System.out.println("Queue after dequeue");
		queue.print(queue);


	}
}
