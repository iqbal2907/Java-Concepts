package com.concept.accessmodifiers;


public class AccessModifierDemo {

	// Properties with access label private
	private int privateId = 1;
	private String privateName = "Mohan";
	private float privateSalary = (float) 90000.25;

	// Properties with access label package
	int packageId = 2;
	String packageName = "Mohan";
	float packageSalary = (float) 90000.25;

	// Properties with access label protected
	protected int protectedId = 3;
	protected String protectedName = "Mohan";
	protected float protectedSalary = (float) 90000.25;

	// Properties with access label public
	public int publicId = 4;
	public String publicName = "Mohan";
	public float publicSalary = (float) 90000.25;

	void accessTestMethod() {

		AccessModifierDemo objAccessModifierDemo = new AccessModifierDemo();
		System.out.println(objAccessModifierDemo.privateId);
		System.out.println(objAccessModifierDemo.privateName);
		System.out.println(objAccessModifierDemo.privateSalary);

	}
}

/*class AccessModifierDemoChild {

	public static void main(String[] args) {
		AccessModifierDemo objAccessModifierDemo = new AccessModifierDemo();
//		System.out.println(objAccessModifierDemo.privateId);  //not accessible because of private modifier
		System.out.println(objAccessModifierDemo.packageId);
		System.out.println(objAccessModifierDemo.protectedId);
		System.out.println(objAccessModifierDemo.publicId);
	}
}*/
