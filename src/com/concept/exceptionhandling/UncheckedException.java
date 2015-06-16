/**
 * UNCHECKED EXCEPTION : are the exceptions that are not checked at compiled time.
 * Exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked.
 *
 *         +-----------+
           | Throwable |
           +-----------+
            /         \
           /           \
     +-------+          +-----------+
     | Error |          | Exception |
     +-------+          +-----------+
       / | \           / | \      \
    \_________/     \_________/    \
      unchecked       checked      +------------------+
                                   | RuntimeException |
                                   +------------------+
                                          / | \
                                       \_________/
                                        unchecked
 */

package com.concept.exceptionhandling;

public class UncheckedException {
	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
