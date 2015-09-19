package com.jp.year2013;

import java.util.ArrayList;
import java.util.List;

public class TestExamImmutableQueueImpl {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(6);
		ExamImmutableQueueImpl<Integer> queue = new ExamImmutableQueueImpl<Integer>(list);
		queue.print();
		
		queue.enqueue(4).print();
		queue.print();
		
		queue.dequeue().print();
		queue.print();
		
		System.out.println(queue.peek());
		queue.print();

		System.out.println(queue.size());

	}

}
