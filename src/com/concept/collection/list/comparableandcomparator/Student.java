package com.concept.collection.list.comparableandcomparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {

	private int id;
	private long height;
	private String name;
	private ArrayList<Subject> subjects;
	
	public Student(int id, long height, String name,
			ArrayList<Subject> subjects) {
		this.id = id;
		this.height = height;
		this.name = name;
		if (subjects != null) {
			this.subjects = subjects;
		} else {
			this.subjects = new ArrayList<Subject>();
		}
	}

	public static Comparator<Student> idComparator = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}
	};

	public static Comparator<Student> nameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.hashCode() - o2.name.hashCode();
		}
	};

	public static Comparator<Student> subjectComparator = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			// return 0;
			return o1.subjects.get(0).compareTo(o2.subjects.get(1));
		}
	};

	public static Comparable<Student> subjectComparable = new Comparable<Student>() {

		@Override
		public int compareTo(Student o1) {
			return 0;
//			return this.subjects.get(0).compareTo(o2.subjects.get(1));
		}
	};

	@Override
	public String toString() {
		return "Student [id=" + id + ", height=" + height + ", name=" + name
				+ ", subjects=" + subjects + "]";
	}
}
