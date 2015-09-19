package com.jp.year2013;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamImmutableQueueImpl<E> implements ExamImmutableQueue<E> {

	private List<E> queue;
	public ExamImmutableQueueImpl() {
		// TODO Auto-generated constructor stub
	}

	public ExamImmutableQueueImpl(List<E> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	@Override
	public ExamImmutableQueue<E> enqueue(E e) {
		// TODO Auto-generated method stub
		if (e == null) {
			throw new IllegalArgumentException();
		}
		List<E> q = new ArrayList<E>(queue);
		q.add(e);
		return new ExamImmutableQueueImpl<E>(q);
	}

	@Override
	public ExamImmutableQueue<E> dequeue() {
		// TODO Auto-generated method stub
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		List<E> q = new ArrayList<E>(queue);
		q.remove(0);
		return new ExamImmutableQueueImpl<E>(q);

	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

	@Override
	public void print() {
		System.out.println(queue);
	}
}
