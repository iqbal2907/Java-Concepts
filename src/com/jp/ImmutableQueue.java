package com.jp;

import java.util.NoSuchElementException;
/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @param <E>
 */
public class ImmutableQueue<E> implements Cloneable {

	private int size = 0;
	private Node<E> head;
	private Node<E> tail;

	public ImmutableQueue() {
		// modify this constructor if necessary, but do not remove default
		// constructor
	}
	// add other constructors if necessary
	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2, 1, 2, 2, 6, 4)
	 * and this object still represents the queue (2, 1, 2, 2, 6) .
	 * </pre>
	 * 
	 * If the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 * @throws CloneNotSupportedException
	 */
	public ImmutableQueue<E> enqueue(E e) throws IllegalArgumentException,
			CloneNotSupportedException {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		@SuppressWarnings("unchecked")
		ImmutableQueue<E> q = (ImmutableQueue<E>) this.clone();
		Node<E> n = new Node<E>(e, tail);
		q.tail = n;
		return q;
	}
	/**
	 * 
	 * @param e
	 * @throws IllegalArgumentException
	 */
	public void add(E e) throws IllegalArgumentException {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		if (head == null && tail == null) {
			Node<E> node = new Node<E>(e, head);
			head = tail = node;
		} else {
			Node<E> node = new Node<E>(e, tail);
			tail = node;
		}
		size++;
	}
	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	 * this method returns a new queue (1, 3, 3, 5, 1)
	 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	 * </pre>
	 * 
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue<E> dequeue() throws CloneNotSupportedException {
		Node<E> f = head;
		if (f == null)
			throw new NoSuchElementException();
		@SuppressWarnings("unchecked")
		ImmutableQueue<E> q = (ImmutableQueue<E>) this.clone();
		Node<E> tail = q.tail;
		while (tail.next != head) {
			tail = tail.next;
		}
		head = tail;
		tail.next = null;
		return q;
	}
	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
	 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public E peek() throws NoSuchElementException {
		Node<E> f = head;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}
	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	public void print() {

		Node<E> tail = this.tail;
		while (tail != null) {
			System.out.print(tail.item + " ");
			tail = tail.next;
		}
	}
	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;
		}
	}
}
class TestImmutableQueue {
	public static void main(String[] args) throws IllegalArgumentException,
			CloneNotSupportedException {
		ImmutableQueue<Character> q = new ImmutableQueue<Character>();

		ImmutableQueue<Character> queue = new ImmutableQueue<Character>();
		queue.add('p');
		queue.add('q');
		queue.add('r');
		queue.add('s');
		queue.add('t');
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());
		System.out.println("--------------------------------------------------------------");

		System.out.println("\nQueue after enquing element :");
		q = queue.enqueue('x');
		q.print();
		System.out.println("\nSize of new queue :" + queue.size());
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());
		System.out.println("\n--------------------------------------------------------------");

		System.out.println("\nQueue after dequing element :");
		q = queue.dequeue();
		q.print();
		System.out.println("\nSize of new queue :" + queue.size());
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());

	}
}