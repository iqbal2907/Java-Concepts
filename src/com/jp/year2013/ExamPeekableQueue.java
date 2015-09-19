package com.jp.year2013;

public interface ExamPeekableQueue<E extends Comparable<E>> {

	public void enqueue(E e);
	
	public E dequeue();
	
	public E peekMedian();

	public E peekMaximum();

	public E peekMinimum();
	
	public int size();

}
