package com.jp.jnr;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ImmutableQueue<E>  {

	private ArrayList<Integer> queue;

	public ImmutableQueue() {
		queue = new ArrayList<Integer>();
	}

	public ImmutableQueue(ArrayList<Integer> queue) {
		this.queue = queue;
	}

	public ImmutableQueue<Integer> enqueue(Integer e) {
		if (e == null)
			throw new IllegalArgumentException();
		ArrayList<Integer> Duplicate = new ArrayList<Integer>(queue);
		Duplicate.add(e);
		return new ImmutableQueue<Integer>(Duplicate);
	}

	public ImmutableQueue<Integer> dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		ArrayList<Integer> Duplicate = new ArrayList<Integer>(queue);
		Duplicate.remove(0);
		return new ImmutableQueue<Integer>(Duplicate);
	}

	public Integer peek() {
		if (queue.isEmpty())
			throw new NoSuchElementException();
		return queue.get(0);
	}

	public int size() {
		return queue.size();
	}

	public String toString() {
		String result = queue.get(0) + "";
		int i;
		for (i = 1; i < queue.size(); i++) {
			result += queue.get(i);
		}
		return result;

	}

	public static void main(String[] args) {
		
		ArrayList<Integer> queu= new ArrayList<Integer>();
		queu.add(2);
		queu.add(1);
		queu.add(2);
		queu.add(2);
		queu.add(6);
		ImmutableQueue<Integer> A = new ImmutableQueue<Integer>(queu);
		try{
		System.out.println(A.peek());
		System.out.println("Queue after enque"+A);
		}
		catch(NoSuchElementException ex)
		{
			ex.printStackTrace();
		}
		
	}
}
