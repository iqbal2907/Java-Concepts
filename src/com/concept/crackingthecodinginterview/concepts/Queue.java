package com.concept.crackingthecodinginterview.concepts;

public class Queue {
	Node first, last, back, front;
	void enqueue(Object item) {
		if (first==null) {
			back = new Node(item);
			first = back;
		} else {
			back.next = new Node(item);
			back = back.next;
		}
	}
	Node dequeue(Node n) {
		if (front != null) {
			Object item = front.data;
			front = front.next;
			return (Node) item;
		}
		return null;
	}
}
