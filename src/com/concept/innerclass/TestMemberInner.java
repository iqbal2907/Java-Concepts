package com.concept.innerclass;

public class TestMemberInner {
	private int data = 30;
	class MemberInnerClass {
		void msg() {
			System.out.println("data is " + data);
		}
	}
	public static void main(String args[]) {
		TestMemberInner obj = new TestMemberInner();
		TestMemberInner.MemberInnerClass in = obj.new MemberInnerClass();
		in.msg();
	}
}
