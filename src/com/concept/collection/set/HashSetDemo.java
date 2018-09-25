package com.concept.collection.set;

import java.util.HashSet;
import java.util.Hashtable;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet<Employee> hashSet = new HashSet<>();
		
		for (int i = 0; i < 5; i++) {
			
			Employee emp = new HashSetDemo().new Employee();
			emp.id=i;
			emp.setName("Emp"+i);
			hashSet.add(emp);			
		}
		
		HashSet<Employee> hashSet2 = (HashSet<Employee>)hashSet.clone();
		
		System.out.println("************ hashset ************");
		for (Employee emp : hashSet) {
			if (emp.id==1) {
				emp.setName("test");
			}
			System.out.println(emp);
		}
		
		System.out.println("************ in cloned hashset ************");
		for (Employee emp : hashSet2) {
			System.out.println(emp);			
		}

	}
	
	class Employee {
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
	}
}
