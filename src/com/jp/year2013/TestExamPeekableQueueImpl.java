package com.jp.year2013;

public class TestExamPeekableQueueImpl {

	public static void main(String[] args) {
		ExamPeekableQueueImpl<Integer> queue = new ExamPeekableQueueImpl<Integer>();
		queue.enqueue(7);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(3);

		
/*		System.out.println(queue.size());
		queue.print();
		
		System.out.println(queue.dequeue());
		queue.print();

		System.out.println(queue.peekMaximum());
		queue.print();

		System.out.println(queue.peekMinimum());
		queue.print();
*/
		System.out.println(queue.peekMedian());
		queue.print();

	}
}
