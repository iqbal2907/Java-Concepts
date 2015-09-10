package com.concept.linkedlist.singly;

import java.rmi.UnexpectedException;

public class MyList {

	private Node start;
	private Node end;
	public int SIZE;

	public int size() {
		return SIZE;
	}

	public boolean isEmpty() {
		return SIZE == 0;
	}

	public void add(int data) {
		if (!isEmpty()) {
			Node temp = new Node(data);
			temp.next = start;
			start = temp;
		} else {
			start = new Node(data);
			end = start;
		}
		SIZE++;
	}

	public void add(int index, int data) throws UnexpectedException {
		if (index > SIZE-1 || index < 0) {
			throw new ArrayIndexOutOfBoundsException("not a valid index");
		}
		if (!isEmpty()) {
			Node newnode = new Node(data);
			if (index == 0) {
				end.next = newnode;
				end = newnode;
			} else {
				Node temp = start;
				for (int i = 0; i < SIZE-(index+1); i++) {
					temp = temp.next;
				}
				newnode.next = temp.next;
				temp.next = newnode;
			}
		}
		SIZE++;
	}
	
	public void remove(int index) throws UnexpectedException {
		if (index > SIZE-1 || index < 0) {
			throw new UnexpectedException("not a valid index");
		}
		if (!isEmpty()) {
			if (index == 0) {
				Node temp = start;
				while (temp.next.next!=null) {
					temp = temp.next;
				}
				temp.next=null;
				end = temp;
			} else if (index == SIZE - 1) {
				start = start.next;
			} else {
				Node temp = start;
				for (int i = 0; i < SIZE-(index+2); i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
			}
		}
		SIZE--;
	}

	public void print() {
		if (start != null) {
			printList(start);
		}
	}

	public void printList(Node node) {
		if (node.next != null) {
			printList(node.next);
			System.out.println(node.data);
		} else {
			System.out.println(node.data);
		}
	}

	class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		MyList list = new MyList();
		System.out.println(list.isEmpty());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.print();
		System.out.println("SIZE : " + list.SIZE);

		try {
			list.add(4, 15);
			//list.print();
			//System.out.println("SIZE : " + list.SIZE);
		} catch (UnexpectedException e) {
			e.printStackTrace();
		}
		
		try {
			list.remove(0);
			list.print();
			System.out.println("SIZE : " + list.SIZE);
		} catch (UnexpectedException e) {
			e.printStackTrace();
		}
	}
}