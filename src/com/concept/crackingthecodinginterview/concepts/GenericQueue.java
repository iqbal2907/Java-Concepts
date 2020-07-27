package com.concept.crackingthecodinginterview.concepts;

public class GenericQueue<T> {
	GenericQueue<T> next = null;
	T data;

	public GenericQueue() {
	}

	public GenericQueue(T data) {
		this.data = data;
	}

/*	public GenericQueue(int size) {
		for (int i = 0; i < size; i++) {
			GenericQueue<T> temp = new GenericQueue<T>();
			temp.next = null;

		}
	}
*/
	public void enqueue(T data) {
		GenericQueue<T> temp = new GenericQueue<T>();
		temp.data = data;
		temp.next = null;
		GenericQueue<T> queue = this;
		while (queue.next != null) {
			queue = queue.next;
		}
		queue.next = temp;
	}

	public T dequeue() {
		GenericQueue<T> queue = this;
		if (queue.next == null) {
			data = queue.data;
			queue = null;
			return data;
		} else {
			data = queue.data;
			queue = queue.next.next;
//			System.out.println("next data: "+queue.data);
			return data;
		}
	}

	public void print(GenericQueue<T> queue) {
		if (queue == null) {
			System.out.println("queue is empty");
			return;
		} else if (queue.next == null) {
			System.out.println("queue has only one element");
			System.out.println(queue.data);
			return;
		} else {
			while (queue.next != null) {
				System.out.println(queue.data);
				queue = queue.next;
				if (queue.next == null) {
					System.out.println(queue.data);
				}
			}
		}
	}


}
