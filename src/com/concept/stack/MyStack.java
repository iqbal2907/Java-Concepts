package com.concept.stack;

public class MyStack {

	public static void main(String[] args) {
		MyStackO1 ms = new MyStackO1();
		ms.push(26);
/*		ms.push(27);
		ms.push(28);
		ms.push(29);
		ms.push(30);
		ms.push(31);
		ms.push(32);
		ms.push(33);
		ms.push(34);
*/		
		System.out.println("Middle : "+ms.findMiddle());

//		System.out.println("stack size : "+ms.count);
		System.out.println(ms.pop());
//		System.out.println("stack size : "+ms.count);
		System.out.println(ms.pop());
//		System.out.println("stack size : "+ms.count);
//		System.out.println(ms.pop());
//		System.out.println("stack size : "+ms.count);
//		System.out.println(ms.pop());
//		System.out.println("stack size : "+ms.count);
//		System.out.println(ms.pop());
//		System.out.println("stack size : "+ms.count);

//		System.out.println("Middle : "+ms.findMiddle());
		
	}
}

class Node{
	Node next;
	Node prev;
	int data;
	Node(int i){
		data=i;
	}
}

class MyStackO1 {
	
	int count = 0;
	private Node head = null;
	private Node middle = null;
	
	public void push(int i) {
		Node nn = new Node(i);
		nn.prev=null;
		nn.next=null;
		
		if (head==null) {
			head = nn;
			count++;
			middle = head;
		} else {
			nn.next = head;
			head.prev = nn;
			head = nn;
			count++;
            if((count % 2) != 0) // Update mid if ms->count is odd
                middle=middle.prev;
		}
		
	}
	
	public int pop() {
		if (head==null) {
			return -1;			
		}
		if (count==1) {
			count--;
			int i = head.data; 
			head = null;
			return i;
		}
		Node p = head;
		head = head.next;
		head.prev=null;
		count--;

        if((count % 2) != 0) // Update mid if ms->count is odd
            middle=middle.next;

		return p.data;
	}

	public int deleteMiddle() {
		if (head==null) {
			return -1;			
		}
		if (count==1) {
			int i = head.data;
			head = null;
			count--;
			return i;
		}
		int i = middle.data;
////////////////////// check delete logic		
        if((count % 2) != 0) // Update mid if ms->count is odd
            middle=middle.next;
		return i;
	}

	public int findMiddle() {
		if (head == null) {
			return -1;			
		}
		return middle.data;
	}

}