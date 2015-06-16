/**
 * CHECKED EXCEPTION : are the exceptions that are checked at compile time.
 * If some code within a method throws a checked exception, then the method must either
 * handle the exception or it must specify the exception using throws keyword.
 *
 *         +-----------+
           | Throwable |
           +-----------+
            /         \
           /           \
     +-------+          +-----------+
     | Error |          | Exception |
     +-------+          +-----------+
       / | \              / | \      \
    \_________/        \_________/    \
     unchecked           checked       +------------------+
                                       | RuntimeException |
                                       +------------------+
                                              / | \
                                           \_________/
                                            unchecked

 */
package com.concept.exceptionhandling;

public class CheckedException {
	public static void main(String[] args) {

		try {
			throw new ClassNotFoundException(); // this is checked exception
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (Exception e) { // this line can be written because Exception is super class of all
			// TODO: handle exception
		}
	}

}
