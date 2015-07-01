package com.concept.crackingthecodinginterview.concepts;

public class Node {
	Node next = null;
	int data;

	public Node() {
	}

	public Node(int d) {
		data = d;
	}

	public Node(Object item) {
		this.next = (Node) item;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void add(int index, int d) {
		if (index < 0) {
			System.out.println("Index can't be negative");
		}
		Node temp;
		Node indexNode = new Node(d);
		Node n = this;
		for (int i = 1; i < index; i++) {
			n = n.next;
			if (n == null) {
				System.out.println("Index out of bond");
			}
		}
		temp = n.next;
		n.next = indexNode;
		indexNode.next = temp;
	}

	public static Node deleteNode(Node head, int data) {
		Node n = head;
		if (n.data == data) {
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
				return head; /* head didn’t change */
			}
			n = n.next;
		}
		return n;
	}

	public Node delete(int data) {
		Node n = this;
		if (n.data == data) {
			return this.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
				return this; /* head didn’t change */
			}
			n = n.next;
		}
		return n;
	}

	public Node deleteAllDuplicates(int data) {
		Node n = this;
		if (n.next == null) {
			System.out.println("List have only one element");
			return null;
		}
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
			}
			n = n.next;
		}
		return this;
	}

	public static Node delete(Node head, int index) {
		Node n = head;
		for (int i = 1; i < index; i++) {
			n = n.next;
		}
		n.next = n.next.next;
		return head; /* head didn’t change */
	}

	public static void printList(Node head) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.next == null) {
			System.out.println(head.data);
			return;
		}
		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
			if (head.next == null) {
				System.out.println(head.data);
			}
		}
	}
}
