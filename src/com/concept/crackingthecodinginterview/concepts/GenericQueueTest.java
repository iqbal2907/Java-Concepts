package com.concept.crackingthecodinginterview.concepts;

public class GenericQueueTest {

	public static void main(String[] args) {
		GenericQueue<Integer> queue = new GenericQueue<Integer>(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);



		System.out.println("Queue before dequeue");
		queue.print(queue);
		Integer i = queue.dequeue();
		System.out.println("Dequeued element is : "+i);

		System.out.println("Queue after dequeue");
		queue.print(queue);


	}
}
