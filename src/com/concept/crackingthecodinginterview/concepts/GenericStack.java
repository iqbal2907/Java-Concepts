package com.concept.crackingthecodinginterview.concepts;

public class GenericStack<T> {
	GenericStack<T> next = null;
	T data;

	public GenericStack() {
	}

	public GenericStack(T data) {
		this.data = data;
	}

/*	public GenericStack(int size) {
		for (int i = 0; i < size; i++) {
			GenericStack<T> temp = new GenericStack<T>();
			temp.next = null;

		}
	}
*/
	public void push(T data) {
		GenericStack<T> temp = new GenericStack<T>();
		temp.data = data;
		temp.next = null;
		GenericStack<T> stack = this;
		while (stack.next != null) {
			stack = stack.next;
		}
		stack.next = temp;
	}

	public T pop() {
		GenericStack<T> stack = new GenericStack<T>();
		stack = this;
		if (stack.next == null) {
			return stack.data;
		}
		while (stack.next.next != null) {
			stack = stack.next;
		}
		T data = stack.next.data;
		stack.next = null;
		return data;
	}

	public void print(GenericStack<T> stack) {
		if (stack == null) {
			System.out.println("Stack is empty");
			return;
		} else if (stack.next == null) {
			System.out.println("Stack has only one element");
			System.out.println(stack.data);
			return;
		} else {
			while (stack.next != null) {
				System.out.println(stack.data);
				stack = stack.next;
				if (stack.next == null) {
					System.out.println(stack.data);
				}
			}
		}
	}
}
