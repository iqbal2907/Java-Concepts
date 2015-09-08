package com.concept.genralprograms;

public class Test1 extends Test2 {

	public Test2 testMethod1(){
		System.out.println("Test1 : testMethod1(), called.");
		return new Test1();
	}

	public Test2 testMethod2(){
		System.out.println("Test1 : testMethod2(), called.");
		return new Test1();
	}

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.testMethod1();
		Test2 t = t1.testMethod2();
		t.testMethod1();
	}
}

class Test2 {

	public Object testMethod1(){
		System.out.println("Test2 : testMethod1(), called.");
		return null;
	}
}
