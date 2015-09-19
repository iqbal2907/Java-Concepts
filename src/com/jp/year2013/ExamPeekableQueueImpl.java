package com.jp.year2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

	private List<E> queue = new ArrayList<E>();

	@Override
	public void enqueue(E e) {
		if (e == null) {
			throw new IllegalArgumentException("null can't be added");
		}
		queue.add(e);
	}

	@Override
	public E dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		E e = queue.remove(0);
		return e;
	}

	@Override
	public E peekMedian() {
		List<E> tempQueue = new ArrayList<E>(queue);
		Collections.sort(tempQueue);
		System.out.println("Sorted queue : "+tempQueue);
		int index = queue.size()/2;
		return tempQueue.get(index );
	}

	@Override
	public E peekMaximum() {
		List<E> tempQueue = new ArrayList<E>(this.queue);
		E e = Collections.max(tempQueue);
		return e;
	}

	@Override
	public E peekMinimum() {
		List<E> tempQueue = new ArrayList<E>(this.queue);
		E e = Collections.min(tempQueue);
		return e;
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	public void print() {
		System.out.println(queue);
	}
}
