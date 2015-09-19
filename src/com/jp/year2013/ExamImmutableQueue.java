package com.jp.year2013;

public interface ExamImmutableQueue<E> {

	public ExamImmutableQueue<E> enqueue(E e);
	
	public ExamImmutableQueue<E> dequeue();
	
	public E peek();

	public int size();

	public void print();

}
