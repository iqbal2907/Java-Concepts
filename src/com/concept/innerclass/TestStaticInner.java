/**
 * A static class i.e. created inside a class is called static nested class in java. 
 * It cannot access non-static data members and methods. It can be accessed by outer class name.
 * 1. It can access static data members of outer class including private.
 * 2. Static nested class cannot access non-static (instance) data member or method.
 */
package com.concept.innerclass;

public class TestStaticInner {
	static int data = 30;
	static class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}
	public static void main(String args[]) {
		TestStaticInner.Inner obj = new TestStaticInner.Inner();
		obj.msg();
	}
}
//Internal class generated by the compiler
/*
	import java.io.PrintStream;  
	static class TestStaticInner$Inner  
	{  
		TestStaticInner$Inner(){}  
		void msg(){  
		System.out.println((new StringBuilder()).append("data is ")  
		.append(TestOuter1.data).toString());  
		}    
	}  
*/

//Java static nested class example with static method
/**
 * If you have the static member inside static nested class, 
 * you don't need to create instance of static nested class.
 */
class TestOuter{  
	  static int data=30;  
	  static class Inner{  
		  static void msg(){System.out.println("data is "+data);}  
	  }  
	  public static void main(String args[]){  
		  TestOuter.Inner.msg();//no need to create the instance of static nested class  
	  }  
}