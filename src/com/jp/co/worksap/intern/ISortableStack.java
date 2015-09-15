package com.jp.co.worksap.intern;


public interface ISortableStack <E extends Comparable <E>> {
	public void push(E e);
	public E Pop();
	
	public E peekMidElement();
	
	public E peekHighestElement();
	
	public E peekLowestElement();
	
	public int size();

}
