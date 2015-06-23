/**
 * The programming languages which supports following principles are called as Object Oriented Programming Language.
 * 1. Encapsulation : The process of Hiding internal data from outside world and accessing it only through publicly exposed methods is known as data 
 * encapsulation. In java it is achieved by declaring all properties private and public getter/setter methods.
 * 2. Inheritance : In java it is achieved by using extends/implements
 * 3. Polymorphism : In java it is achieved by using method overloading.
 */
package com.concept.oopsprinciples;

//Encapsulation example
public class Principles {
	public static void main(String[] args) {
		Customer customer = new Customer("Ashrafi", 123);
		// accessing directly private variables are not possible
		// accessing through getter methods
		System.out.println(customer.getName());
		System.out.println(customer.getId());

		//setting though setter methods and then accesing it.
		customer.setId(456);
		customer.setName("Iqbal");
		System.out.println(customer.getName());
		System.out.println(customer.getId());

	}
}
class Customer {
	private String name;
	private int id;
	
	Customer(String name, int id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}