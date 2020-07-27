package com.concept.queue;

class MyNode<T>{
	MyNode<T> next;
	T data;
	MyNode(T t){
		data=t;
	}
}

public class MyGenericQueue<T> {
	
	private int count;
	MyNode<T> top =null;
	
	public void add(T t) {
		MyNode<T> newNode = new MyNode<T>(t);
		newNode.next=null;
		
		if (top==null) {
			top = newNode;
			count++;
		} else {
			newNode.next = top;
			top = newNode;
			count++;
		}
		
	}
	
	public T remove() {
		MyNode<T> iterator = top;
		if (top==null) {
			System.out.println("Queue is empty");
			return null;
		} else {
			while (iterator.next.next!=null) {
				iterator = iterator.next;
			}
			T data = iterator.next.data;
			iterator.next = null;
			count--;
			return data;
		}
	}


	public T peek() {
		MyNode<T> iterator = top;
		if (top == null) {
			System.out.println("Queue is empty");
			return null;
		} else {
			while (iterator.next!=null) {
				iterator = iterator.next;
			}
			T data = iterator.data;
			return data;
		}
	}
	
	public int size() {
		return count;
	}
	
	public void print() {
		MyNode<T> iterator = top;
		if (iterator == null) {
			System.out.println("Queue is empty");
		} else {
			while (iterator.next!=null) {
				System.out.print(iterator.data+" -> ");
				iterator = iterator.next;
			}
			System.out.println(iterator.data);
		}
	}
}
