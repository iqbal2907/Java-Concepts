package com.concept.collection.list.comparableandcomparator;

import java.util.Comparator;

public class ComparatorStudent implements Comparator<ComparatorStudent> {

	@Override
	public int compare(ComparatorStudent o1, ComparatorStudent o2) {
		return o1.marks-o2.marks;
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
		return "ComparatorStudent [name=" + name + ", subject=" + subject
				+ ", regId=" + regId + ", marks=" + marks + "]";
	}

	
}
