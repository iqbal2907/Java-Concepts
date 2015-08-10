package com.concept.collection.list.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyComparator {

	public static void main(String[] args) {

		ArrayList<ComparatorStudent> ComparatorStudentList = new ArrayList<ComparatorStudent>();
		for (int i = 0; i < 10; i++) {
			ComparatorStudent st = new ComparatorStudent();
			st.setRegId(i);
			st.setName("name"+i);
			st.setSubject("subject"+i);
			st.setMarks(new Random().nextInt(100));
			ComparatorStudentList.add(st);
		}

		for (int i = 0; i < 10; i++) {
			ComparatorStudent st = new ComparatorStudent();
			st.setRegId(i+11);
			st.setName("name"+i+20);
			st.setSubject("subject"+i);
			st.setMarks(new Random().nextInt(100));
			ComparatorStudentList.add(st);
		}

		Collections.sort(ComparatorStudentList, new ComparatorStudent());
		System.out.println(ComparatorStudentList);

	}
}
