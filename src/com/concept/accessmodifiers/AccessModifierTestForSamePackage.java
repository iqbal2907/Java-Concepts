package com.concept.accessmodifiers;

public class AccessModifierTestForSamePackage extends AccessModifierDemo {

	public static void main(String[] args) {
		AccessModifierDemo objAccessModifierDemo = new AccessModifierDemo();
		System.out.println(objAccessModifierDemo.packageId);
		System.out.println(objAccessModifierDemo.protectedId);
		System.out.println(objAccessModifierDemo.publicId);
	}

}
