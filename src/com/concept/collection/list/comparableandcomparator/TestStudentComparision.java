package com.concept.collection.list.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestStudentComparision {
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
		studentsList.add(new Student(3, (long)5.7, "C", cList));
		studentsList.add(new Student(2, (long)5.6, "B", bList));

		System.out.println("before sort : "+studentsList);
//		Collections.sort(studentsList, Student.idComparator );
		Collections.sort(studentsList, Student.subjectComparator );
//		Collections.sort(studentsList);		//compilation error check why
//		Collections.sort(aList);			//can sort
		//Collections class have above two static method (sort) but not which accept comparable interface implemntation so
		// comparator is always better since we can perform comparision on diffrent values whereas for comparable only one value is possible
		System.out.println("after sort : "+studentsList);

	}
}
