package com.concept.stack;

class MyNode<T>{
	MyNode<T> next;
	T data;
	MyNode(T t){
		data=t;
	}
}

public class MyGenericStack<T> {
	
	private int count = 0;
	private MyNode<T> top = null;
	
	public void push(T t) {
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
	
	public T pop() {
		if (top==null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			T topData = top.data;
			top = top.next;
			count--;
			return topData;
		}
	}


	public T peek() {
		if (top == null) {
			System.out.println("Stack is empty");
			return null;
		}
		return top.data;
	}

	public void print() {
		MyNode<T> iterator = top;
		if (iterator == null) {
			System.out.println("Stack is empty");
		} else {
			while (iterator.next!=null) {
				System.out.println(iterator.data);
				iterator = iterator.next;
			}
			System.out.println(iterator.data);
		}
	}
	
	public int size() {
		return count;
	}
	
	public T findMiddle() {
		int mid = count/2;
		System.out.println("mid is :"+mid);
		MyNode<T> iterator = top;
		while (mid>0) {
			iterator = iterator.next;
			mid--;
		}
		return iterator.data;
	}
	
	public T deleteMiddle() {
		int mid = count/2;
		System.out.println("mid is :"+mid);
		MyNode<T> iterator = top;
		while (mid>1) {
			iterator = iterator.next;
			mid--;
		}
		T midData = iterator.next.data;
		iterator.next = iterator.next.next;
		count--;
		return midData;
	}
}