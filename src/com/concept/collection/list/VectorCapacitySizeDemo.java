package com.concept.collection.list;

import java.util.Vector;

public class VectorCapacitySizeDemo {
    public static void main(String[] args) {

        Vector v = new Vector();
        
        System.out.println("Default Size of vector is : "+v.size());
        System.out.println("Default capacity of vector is : "+v.capacity());
        System.out.println("###################################\n");

        Vector vector = new Vector(3);

        System.out.println("Initial Size of vector is : "+vector.size());
        System.out.println("Initial capacity of vector is : "+vector.capacity());
        
        System.out.println();
        
        Customer c1 = new Customer("cust 1", 21, new Address("house No. 1","street 1","city 1","111"));
        Customer c2 = new Customer("cust 2", 22, new Address("house No. 2","street 2","city 2","222"));
        Customer c3 = new Customer("cust 3", 23, new Address("house No. 3","street 3","city 3","333"));
        Customer c4 = new Customer("cust 4", 24, new Address("house No. 4","street 4","city 4","444"));
        Customer c5 = new Customer("cust 5", 25, new Address("house No. 5","street 5","city 5","555"));
        Customer c6 = new Customer("cust 6", 26, new Address("house No. 6","street 6","city 6","666"));
        Customer c7 = new Customer("cust 7", 27, new Address("house No. 7","street 7","city 7","777"));
        Customer c8 = new Customer("cust 8", 28, new Address("house No. 8","street 8","city 8","888"));
        Customer c9 = new Customer("cust 9", 29, new Address("house No. 9","street 9","city 9","999"));

        vector.add(c1);
        vector.add(c2);
        
        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

        vector.add(c3);
        
        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

        vector.add(c4);

        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

        vector.add(c5);
        vector.add(c6);

        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

        vector.add(c7);

        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

        vector.add(c8);
        vector.add(c9);
        vector.add(c1);  //Since Duplicates are allowed to add in vector
        vector.add(c2);
        vector.add(c3);
        vector.add(c4);

        System.out.println("Checking reached its capacity or not :");
        System.out.println("Capacity : "+vector.capacity());
        System.out.println("Size : "+vector.size());
        System.out.println("**********************\n");

    }
}

class Address{

    String hNo,street,city,ph;

    Address(String hNo, String street, String city, String ph){
        this.hNo=hNo;
        this.street=street;
        this.city=city;
        this.ph=ph;
    }
}

class Customer{
    String name;
    int age;
    Address address;
    
    Customer(String name, int age, Address address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    
    @Override
    public String toString(){
        return "Name : "+name+"\nAge : "+age+"\nAddress : "+"\nCity : "+address.city+", street: "+address.street+", House No. : "+address.hNo+", Phone No. : "+address.ph;
    }
}