package com.concept.linkedlist.singly;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int N;

	//constructor
	public LinkedList() {
		first = null;
		last = null;
		N = 0;
	}

	// add method to add items into the list
	public void add(T item) {
		if (item == null) {
			throw new NullPointerException(
					"The first argument for addLast() is null.");
		}
		if (!isEmpty()) {
			Node prev = last;
			last = new Node(item, null);
			prev.next = last;
		} else {
			last = new Node(item, null);
			first = last;
		}
		N++;
	}

	// remove method to remove items from the list
	public boolean remove(T item) {
		if (isEmpty()) {
			throw new IllegalStateException(
					"Cannot remove() from and empty list.");
		}
		boolean result = false;
		Node prev = first;
		Node curr = first;
		while (curr.next != null || curr == last) {
			if (curr.data.equals(item)) {
				// remove the last remaining element
				if (N == 1) {
					first = null;
					last = null;
				}
				// remove first element
				else if (curr.equals(first)) {
					first = first.next;
				}
				// remove last element
				else if (curr.equals(last)) {
					last = prev;
					last.next = null;
				}
				// remove element
				else {
					prev.next = curr.next;
				}
				N--;
				result = true;
				break;
			}
			prev = curr;
			curr = prev.next;
		}
		return result;
	}

	// returns size of the list
	public int size() {
		return N;
	}

	// tells whether list is empty or not
	public boolean isEmpty() {
		return N == 0;
	}

	// inner class Node to create list node
	private class Node {
		private T data;
		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// To print a list using iterator
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	//inner class for iterating a list
	private class LinkedListIterator implements Iterator<T> {
		private Node current = first;

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T item = current.data;
			current = current.next;
			return item;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// to convert list into string
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (T item : this) // here we are using this coz our class LinkedList implments Iterable interface
			s.append(item + " ");
		return s.toString();
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
/*		while (!StdIn.isEmpty()) {
			String input = StdIn.readString();
			if (input.equals("print")) {
				StdOut.println(list.toString());
				continue;
			}
			if (input.charAt(0) == ('+')) {
				list.add(input.substring(1));
				continue;
			}
			if (input.charAt(0) == ('-')) {
				list.remove(input.substring(1));
				continue;
			}
			break;
		}*/
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		System.out.println(list.toString());
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

	}
}