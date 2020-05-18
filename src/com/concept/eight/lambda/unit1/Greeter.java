package com.concept.eight.lambda.unit1;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	
	public static void main(String[] args) {

		Greeter greeter = new Greeter();
		
		Greeting lambdaGreeting = () -> System.out.print("Hello world!\n");
		
		Greeting anonymousClassGreeting = new Greeting() {
			public void perform() {
				System.out.print("anonymousClassGreeting : Hello world!\n");
			}
		};
		
		greeter.greet(() -> System.out.print("lambda : Hello world!\n"));
		greeter.greet(anonymousClassGreeting);
	}

}



