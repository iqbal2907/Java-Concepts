package com.concept.linkedlist.singly;

import java.util.Random;

import com.concept.linkedlist.singly.MyList.Node;

public class ListWithLoop {
	Node head;

	public ListWithLoop() {
		int randomNum = 5 + (int) (Math.random() * 10);
		Node pointOfLoop = null, head = this.head;
		for (int i = 0; i < 20; i++) {
			Node node = new MyList().new Node(i);
			if (head == null) {
				head = node;
				this.head = head;
			} else {
				head.next = node;
				head = node;
			}
			if (randomNum > 0) {
				randomNum--;
				pointOfLoop = node;
			}
		}
		System.out.println("looping at : "+pointOfLoop.data);
		head.next = pointOfLoop;
	}

	public void myPrint() {
		Node temp = this.head;
		int i = 0;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
			i++;
			if (i > 50) {
				break;
			}
		}
	}

	private boolean detectLoop() {
		Node head = this.head;
		if (head.next == null) {
			return false;
		} else {
			Node slow = head, fast = head;
			while (fast.next!=null && fast.next.next!=null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow.data == fast.data) {
					System.out.println(slow.data+" : "+fast.data);
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {

		ListWithLoop loopedList = new ListWithLoop();
		loopedList.myPrint();
		System.out.println(loopedList.detectLoop());

		// int randomNum = 5 + (int)(Math.random()*10);
		// System.out.println(randomNum);
	}

}
