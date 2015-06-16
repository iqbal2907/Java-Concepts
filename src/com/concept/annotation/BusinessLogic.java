package com.concept.annotation;

/*
 * This Class demonstrates use of Todo annotation defined in Todo.java
 */

public class BusinessLogic {
	public BusinessLogic() {
		super();
	}

	public void compltedMethod() {
		System.out.println("This method is complete");
	}

	@Todo(priority = Todo.Priority.HIGH)
	public void notYetStartedMethod() {
		// No Code Written yet
	}

	@Todo(priority = Todo.Priority.MEDIUM, author = "Ashrafi", status = Todo.Status.STARTED)
	public void incompleteMethod1() {
		// Some business logic is written
		// But its not complete yet
	}

	@Todo(priority = Todo.Priority.LOW, status = Todo.Status.STARTED)
	public void incompleteMethod2() {
		// Some business logic is written
		// But its not complete yet
	}
}
