package com.concept.collection.list.comparableandcomparator;

public class ComparableStudent implements Comparable<ComparableStudent> {

	@Override
	public int compareTo(ComparableStudent o) {
		//		to sort on the basis of marks 
		return this.getMarks()-o.getMarks();
		//		to sort on the basis of name
		//return (this.name).compareTo(o.name);
}

	private String name;
	private String subject;
	private int regId;
	private int marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "ComparableStudent [name=" + name + ", subject=" + subject
				+ ", regId=" + regId + ", marks=" + marks + "]";
	}

	
}
