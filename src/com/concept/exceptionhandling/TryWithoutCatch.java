/**
 * We can write a try block without catch but in this situation finally block is mandatory.
 */
package com.concept.exceptionhandling;

public class TryWithoutCatch {

	public static void main(String[] args) {
		try {
			System.out.println("inside try block");
		} finally {
			System.out.println("inside finally block");
		}
	}
}
