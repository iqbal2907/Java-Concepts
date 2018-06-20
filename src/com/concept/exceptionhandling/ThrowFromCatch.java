package com.concept.exceptionhandling;

public class ThrowFromCatch {

	static void fun()
	{
		try
		{
			throw new NullPointerException("demo"); //this thrown exception will be caught by catch block
			
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught inside fun().");
			throw e; // rethrowing the exception
		}
		//System.out.println("after catch"); //this will become unreachable code since exception is thrown from catch block
											// hence execution will be terminated at that line.
	}

	public static void main(String args[])
	{
		try
		{
			fun();
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught in main.");
		}
	}
}
