package com.concept.crackingthecodinginterview.concepts;

public class Demo {
	Demo next = null;
	int data;
	public Demo(int d) {
		data = d;
	}
	void appendToTail(int d) {
		Demo end = new Demo(d);
		Demo n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
