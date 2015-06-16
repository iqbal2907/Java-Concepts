package com.concept.collection.list;

import java.util.ArrayList;

public class ArrayListCapacitySizeDemo {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        System.out.println("Default Size of ArrayList is : "+al.size());
        //We cannot see capacity since java doesn't provide this facility for ArrayList
        System.out.println("Default Capacity of ArrayList is : " );
        System.out.println("###################################\n");

        Customer c1 = new Customer("cust 1", 21, new Address("house No. 1","street 1","city 1","111"));
        Customer c2 = new Customer("cust 2", 22, new Address("house No. 2","street 2","city 2","222"));
        Customer c3 = new Customer("cust 3", 23, new Address("house No. 3","street 3","city 3","333"));
        Customer c4 = new Customer("cust 4", 24, new Address("house No. 4","street 4","city 4","444"));
        Customer c5 = new Customer("cust 5", 25, new Address("house No. 5","street 5","city 5","555"));
        Customer c6 = new Customer("cust 6", 26, new Address("house No. 6","street 6","city 6","666"));
        Customer c7 = new Customer("cust 7", 27, new Address("house No. 7","street 7","city 7","777"));
        Customer c8 = new Customer("cust 8", 28, new Address("house No. 8","street 8","city 8","888"));
        Customer c9 = new Customer("cust 9", 29, new Address("house No. 9","street 9","city 9","999"));

        @SuppressWarnings("rawtypes")
        ArrayList arrayList = new ArrayList(3);

        System.out.println("Initial Size of ArrayList is : "+arrayList.size());
        System.out.println("###################################\n");

        arrayList.add(c1);
        arrayList.add(c2);

        System.out.println("Checking reached its size or not :");
        System.out.println("Size : "+arrayList.size());
        System.out.println("**********************\n");

        arrayList.add(c3);
        System.out.println("Checking reached its size or not :");
        System.out.println("Size : "+arrayList.size());
        System.out.println("**********************\n");

        al.ensureCapacity(5);

        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);
        arrayList.add(c4);

        System.out.println("Checking reached its size or not :");
        System.out.println("Size : "+arrayList.size());
        System.out.println("**********************\n");

    }
}