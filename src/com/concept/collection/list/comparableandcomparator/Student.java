package com.concept.collection.list.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class test {
	public static void main(String[] args) {
		ArrayList<Student> studentsList = new ArrayList<Student>();
	
		ArrayList<Subject> aList = new ArrayList<Subject>();
		aList.add(new Subject(85, "phy"));
		aList.add(new Subject(94, "maths"));
		aList.add(new Subject(71, "che"));

		ArrayList<Subject> bList = new ArrayList<Subject>();
		bList.add(new Subject(59, "phy"));
		bList.add(new Subject(95, "maths"));
		bList.add(new Subject(77, "che"));
		
		ArrayList<Subject> cList = new ArrayList<Subject>();
		cList.add(new Subject(88, "phy"));
		cList.add(new Subject(67, "maths"));
		cList.add(new Subject(65, "che"));

		studentsList.add(new Student(1, (long)5.5, "A", aList));
		studentsList.add(new Student(5, (long)5.6, "B", bList));
		studentsList.add(new Student(3, (long)5.7, "C", cList));

		System.out.println("before sort : "+studentsList);
		Collections.sort(studentsList, Student.idComparator );
		System.out.println("after sort : "+studentsList);

	}
}

public class Student {

	private int id;
	private long height;
	private String name;
	private ArrayList<Subject> subjects;
	public Student(int id, long height, String name, ArrayList<Subject> subjects) {
		this.id = id;
		this.height = height;
		this.name = name;
		if (subjects!=null){
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
	

	public static Comparator<Student> subjectComparator = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			return 0;
//			return o1.subjects.get(0) > o2.subjects.get(0);
		}
	};

	@Override
	public String toString() {
		return "Student [id=" + id + ", height=" + height + ", name=" + name
				+ ", subjects=" + subjects + "]";
	}
}

class Subject implements Comparable<Subject>{

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
