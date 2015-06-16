package com.concept.annotation;

/*
 * This Class demonstrates use of annotations using reflection.
 *
 */

import java.lang.reflect.Method;

public class TodoReport {
	public TodoReport() {
		super();
	}

	public static void main(String[] args) {
		getTodoReportForBusinessLogic();
	}

	/**
	 * This method iterates through all messages of BusinessLogic class and
	 * fetches annotations defined on each of them. After that it displays the
	 * information from annotation accordingly.
	 */
	private static void getTodoReportForBusinessLogic() {

		Class<BusinessLogic> businessLogicClass = BusinessLogic.class;
		for (Method method : businessLogicClass.getMethods()) {
			Todo todoAnnotation = method.getAnnotation(Todo.class);
			if (todoAnnotation != null) {
				System.out.println(" Method Name : " + method.getName());
				System.out.println(" Author : " + todoAnnotation.author());
				System.out.println(" Priority : " + todoAnnotation.priority());
				System.out.println(" Status : " + todoAnnotation.status());
				System.out.println(" --------------------------- ");
			}
		}

		// Code for getting a particular method of a class
		try {
			System.out.println(BusinessLogic.class.getMethod("compltedMethod", null));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int []arr = {1,2,3,4,5};
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
