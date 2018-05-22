package com.concept.genralprograms;

import java.util.Objects;

public class EqualsAndHashcodeAndClone {
	public static void main(String[] args) {
		Address add1 = new Address("Udaya siri", 203, "Gautami");
		Address add1copy = new Address("Udaya siri", 203, "Gautami");
		Address add1copy2 = new Address("Udaya siri", 203, "Gautami");
		Address add2 = new Address("Aparna", 1108, "Kondapur");
		
		Employee emp1 = new Employee(1, "Ram", 1000.00f, add1);
		Employee emp1copy = new Employee(1, "Ram", 1000.00f, add1copy);
		Employee emp1copy2 = new Employee(1, "Ram", 1000.00f, add1copy2);
		
		Employee emp2 = new Employee(1, "Rahim", 2000.00f, add2);
		

		//reflexive
		System.out.println("reflexive test : ");
		System.out.println(emp1.equals(emp1));
		//symmetric
		System.out.println("symmetric test : ");
		System.out.println(emp1.equals(emp2) && emp2.equals(emp1));
		System.out.println(emp1.equals(emp1copy) && emp1copy.equals(emp1));
		//transitive
		System.out.println("transitive test : ");
		System.out.println(emp1.equals(emp1copy) && emp1copy.equals(emp1copy2) && emp1.equals(emp1copy2));

		System.out.println("hashCode value : ");
		System.out.println(emp1.hashCode());
		System.out.println(emp1copy.hashCode());
		System.out.println(emp2.hashCode());
		
		System.out.println(add1.hashCode());
		System.out.println(add2.hashCode());
		
		System.out.println("toString value : ");
		System.out.println(emp1.toString());
		System.out.println(emp1copy.toString());
		System.out.println(emp2.toString());

		System.out.println(add1.toString());
		System.out.println(add2.toString());
		

		// Clone method check deep/shallow cloning
		Employee emp = new Employee(1, "Ram", 1000.00f, add1);
		Employee empClone = null;
		try {
			empClone = (Employee)emp.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(emp == empClone);
		System.out.println(emp.equals(empClone));
		
		System.out.println(emp.getAddress() == empClone.getAddress());
		System.out.println(emp.getAddress().equals(empClone.getAddress()));


	}
}
class Employee implements Cloneable {
	int id;
	String name;
	float salary;
	Address address;
	
	public Employee(int id, String name, float salary, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	
	
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Employee empclone = (Employee)super.clone();
		//if clone method is also implemented in Address class we can use following line
		//Address addclone = (Address)this.getAddress().clone();
		// otherwise
		Address addclone = new Address(this.getAddress().apartment, this.getAddress().flatNo, this.getAddress().locality);
		empclone.setAddress(addclone);
		return empclone;
	}

}

class Address implements Cloneable {
	String apartment;
	int flatNo;
	String locality;

	public Address(String apartment, int flatNo, String locality) {
		super();
		this.apartment = apartment;
		this.flatNo = flatNo;
		this.locality = locality;
	}
	
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

	@Override
	public int hashCode() {
/*		int result = 1;
		final int prime = 31;
		result = prime * result + apartment.hashCode();
		result = prime * result + flatNo;
		result = prime * result + locality.hashCode();

		return result;*/
		return Objects.hash(apartment, flatNo, locality);
	}

	@Override
	public boolean equals(Object o) {

		if (o != null && o instanceof Address) {
			Address add = (Address) o;
			if (this == add) {
				return true;
			}
			return add.flatNo == this.flatNo
					&& add.apartment.equals(this.apartment)
					&& add.locality.equals(this.locality);
		}
		return false;
	}
	
/*	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
}
