package com.concept.accessmodifierstest;

import com.concept.accessmodifiers.AccessModifierDemo;

public class AccessModifierTestForOtherPackage extends AccessModifierDemo {

	public static void main(String[] args) {
		AccessModifierDemo objAccessModifierDemo = new AccessModifierDemo();
//		System.out.println(objAccessModifierDemo.packageId);  //not accessible because of modifier package
//		System.out.println(objAccessModifierDemo.protectedId);
		System.out.println(objAccessModifierDemo.publicId);
	}

}
