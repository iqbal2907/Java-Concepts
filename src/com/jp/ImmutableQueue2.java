package com.jp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.NoSuchElementException;
/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @param <E>
 */
@SuppressWarnings("serial")
public class ImmutableQueue2<E> implements Cloneable,Serializable {

	private int size = 0;
	private Node<E> head;
	private Node<E> tail;

	public ImmutableQueue2() {
		// modify this constructor if necessary, but do not remove default
		// constructor
	}
	public ImmutableQueue2(ImmutableQueue2<E> ImmutableQueue2) {
		ImmutableQueue2.head = this.head;
		ImmutableQueue2.tail = this.tail;
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
	public ImmutableQueue2<E> enqueue(E e) throws IllegalArgumentException,
			CloneNotSupportedException {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		@SuppressWarnings("unchecked")
		ImmutableQueue2<E> q = (ImmutableQueue2<E>) this.clone();
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
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue2<E> dequeue() {
		Node<E> f = head;
		if (f == null)
			throw new NoSuchElementException();
		ImmutableQueue2<E> q = getClone(this);
		Node<E> tail = q.tail;
		while (tail.next.next != null) {
			tail = tail.next;
		}
		head = tail;
		tail.next = null;
		return q;
	}

	@SuppressWarnings("unchecked")
	private ImmutableQueue2<E> getClone(ImmutableQueue2<E> q) {
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ImmutableQueue2<E> queue = null;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(q);
			oos.flush();
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			queue = (ImmutableQueue2<E>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return queue;
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
	private static class Node<E> implements Serializable {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;
		}
	}
}
class TestImmutableQueue2 {
	public static void main(String[] args) throws IllegalArgumentException,
			CloneNotSupportedException {
		ImmutableQueue2<Character> q = new ImmutableQueue2<Character>();

		ImmutableQueue2<Character> queue = new ImmutableQueue2<Character>();
		queue.add('p');
		queue.add('q');
		queue.add('r');
		queue.add('s');
		queue.add('t');
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());
		System.out
				.println("--------------------------------------------------------------");

		System.out.println("\nQueue after enquing element :");
		q = queue.enqueue('x');
		q.print();
		System.out.println("\nSize of new queue :" + queue.size());
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());
		System.out
				.println("\n--------------------------------------------------------------");

		System.out.println("\nQueue after dequing element :");
		q = queue.dequeue();
		q.print();
		System.out.println("\nSize of new queue :" + queue.size());
		System.out.println("\nOriginal queue :");
		queue.print();
		System.out.println("\nSize of original queue :" + queue.size());

	}
}