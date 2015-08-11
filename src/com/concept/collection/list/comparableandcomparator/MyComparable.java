package com.concept.collection.list.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyComparable {

	public static void main(String[] args) {

		ArrayList<ComparableStudent> ComparableStudentList = new ArrayList<ComparableStudent>();
		for (int i = 0; i < 10; i++) {
			ComparableStudent st = new ComparableStudent();
			st.setRegId(i);
			st.setName("name"+i);
			st.setSubject("subject"+i);
			st.setMarks(new Random().nextInt(100));
			ComparableStudentList.add(st);
		}

		for (int i = 0; i < 10; i++) {
			ComparableStudent st = new ComparableStudent();
			st.setRegId(i+11);
			st.setName("name"+i+20);
			st.setSubject("subject"+i);
			st.setMarks(new Random().nextInt(100));
			ComparableStudentList.add(st);
		}

		Collections.sort(ComparableStudentList);
		System.out.println(ComparableStudentList);

	}
}
