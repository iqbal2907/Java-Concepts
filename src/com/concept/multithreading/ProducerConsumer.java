package com.concept.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {

		final Product p = new Product();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					p.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Product {

	List<Product> productList = new ArrayList<>();
	Boolean listFull = false;
	int capacity = 2;
	int value = 0;

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (!listFull) {
					while (productList.size() != capacity) {
						productList.add(new Product());
						System.out.println("Producing -----"+ ++value);
						Thread.sleep(1000);
					}
					listFull = true;
					wait();
				}
				notify();
			} 
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				
				while (productList.size() == 0)
					wait();

				if (listFull) {
					while (!productList.isEmpty()) {
						productList.remove(productList.size()-1);
						System.out.println("consuming -----"+ value--);
						Thread.sleep(1000);
					}
					listFull = false;
				}
				notify();
			} 
		}
	}

}