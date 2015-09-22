package com.jp.year2012;

public interface SortableStack<E extends Comparable<E>> {

	public void push(E e);

	public E Pop();

	public E peekMidElement();

	public E peekHighestElement();

	public E peekLowestElement();

	public int size();

}