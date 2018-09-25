package com.concept.genralprograms;

public class HashcodeTest {

	
	public static void main(String[] args) {

		Student student = new Student(1, "Yogesh", "Hyderabad");
		int hashvalue = student.hashCode();
		System.out.println("Yogesh hashvalue : "+hashvalue);
		
		student.setName("Faizan");
		student.setCity("Delhi");
		student.setId(25);
		
		hashvalue = student.hashCode();
		System.out.println("Modified Faizan hashvalue : "+hashvalue);
		
		//*****************************************************
		
		Student student2 = new Student(2, "Akash", "Bihar");
		int hashvalue2 = student2.hashCode();
		System.out.println("Akash hashvalue : "+hashvalue2);
		
		student2.setName("Dilshad");
		student2.setCity("UttarPradesh");
		student2.setId(26);
		
		hashvalue2 = student2.hashCode();
		System.out.println("Modified Dilshad hashvalue : "+hashvalue2);

		//*****************************************************
		student = new Student(1, "Yogesh", "Hyderabad");
		hashvalue = student.hashCode();
		System.out.println("Yogesh hashvalue : "+hashvalue);
		
		student.setName("Faizan");
		student.setCity("Delhi");
		student.setId(25);
		
		hashvalue = student.hashCode();
		System.out.println("Modified Faizan hashvalue : "+hashvalue);

	}
}

class Student{
	private int id;
	private String name;
	private String city;
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
/*	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
*/	
}