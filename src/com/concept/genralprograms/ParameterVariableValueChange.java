package com.concept.genralprograms;

public class ParameterVariableValueChange {

	String strArr[] = {"a"};
	
	public static void main(String[] args) {

		TestVar test = new TestVar(2, 4);

		
		TestVar t = new TestVar(2, 4);
		System.out.println("i before change in main : "+t.i);
		System.out.println("j before change in main : "+t.j);

		
		test.changeIJ(t);
		System.out.println("i after change in main : "+t.i);
		System.out.println("j after change in main : "+t.j);

		System.out.println("test i : "+test.i);
		System.out.println("test j "+test.j);

	}
}


class TestVar {
	int i,j;
	TestVar(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public void changeIJ(TestVar t){
		
		//here current object is pointed by two reference variables t & this
		System.out.println("i before = "+t.i);
		System.out.println("j before = "+t.j);
		t.i = 10;
		t.j = 20;
		System.out.println("i after = "+t.i);
		System.out.println("j after = "+t.j);
		this.i=100;
		this.j=200;
	}
}