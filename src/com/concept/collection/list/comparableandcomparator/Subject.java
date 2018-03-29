package com.concept.collection.list.comparableandcomparator;

import java.util.Comparator;

class Subject implements Comparable<Subject> {

	private int marks;
	private String subjectName;
	
	public Subject(int marks, String subjectName) {
		this.marks= marks;
		this.subjectName = subjectName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public static Comparator<Subject> marksComparator = new Comparator<Subject>() {
		@Override
		public int compare(Subject o1, Subject o2) {
			return o1.marks-o2.marks;
		}
	};
	
	public static Comparator<Subject> subjectNameComparator = new Comparator<Subject>() {
		@Override
		public int compare(Subject o1, Subject o2) {
			return o1.compareTo(o2);
		}
	};

	@Override
	public int compareTo(Subject o) {
		return this.subjectName.compareTo(o.subjectName);
	}
	
	@Override
	public String toString() {
		return "(" + subjectName + ", " + marks + ")";
	}
}
