package com.concept.serialization;

public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String name;
	public String address;
	public transient int SSN; //transient variable can't be serialized
	public int number;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}

/*
POINTS TO REMEMBER

1. Serialization in java is a mechanism of writing the state of an object into a byte stream.
2. It is mainly used in Hibernate, RMI, JPA, EJB, JMS technologies.
3. The reverse operation of serialization is called deserialization.
4. The String class and all the wrapper classes implements java.io.Serializable interface by default.
	Java Serialization with Inheritance (IS-A Relationship)
5. Parent class properties are inherited to subclasses so if parent class is Serializable, subclass would also be.
	Java Serialization with Aggregation (HAS-A Relationship)
6. If a class has a reference of another class, all the references must be Serializable otherwise serialization process will not be performed. In such case, NotSerializableException is thrown at runtime.
	/** Note: All the objects within an object must be Serializable.
7. If there is any static data member in a class, it will not be serialized because static is the part of class not object.
8. Rule: In case of array or collection, all the objects of array or collection must be serializable. If any object is not serialiizable, serialization will be failed.
9. If you don't want to serialize any data member of a class, you can mark it as transient.

	Advantage of Java Serialization
1. It is mainly used to travel object's state on the network (known as marshaling).

> Serializable is a marker interface (has no body). It is just used to "mark" java classes which support a certain capability.



*/


/**
Externalizable in java
----------------------

The Externalizable interface provides the facility of writing the state of an object into a byte stream in compress format. It is not a marker interface.

The Externalizable interface provides two methods:

public void writeExternal(ObjectOutput out) throws IOException
public void readExternal(ObjectInput in) throws IOException

*/
