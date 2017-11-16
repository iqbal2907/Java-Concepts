
public class Test {

	public static void main( String[] args ) {
	    Dog aDog = new Dog("Max");
	    // we pass the object to foo
	    foo(aDog);
	    // aDog variable is still pointing to the "Max" dog when foo(...) returns
	    System.out.println(aDog.getName());
	    aDog.getName().equals("Max"); // true, java passes by value
	    aDog.getName().equals("Fifi"); // false 
	}

	public static void foo(Dog d) {
	    d.getName().equals("Max"); // true
	    // change d inside of foo() to point to a new Dog instance "Fifi"
	    d = new Dog("Fifi");
	    System.out.println(d.getName());
	    d.getName().equals("Fifi"); // true
	}
}

class Dog {

	private String name;

	Dog(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

