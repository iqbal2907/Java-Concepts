package com.concept.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {

        //Declaration
        ArrayList arrayList1 = new ArrayList();
        ArrayList <?> arrayList2 = new ArrayList(); //same as above
        ArrayList <String> arrayList3 = new ArrayList<String>();

        Customer c1 = new Customer("cust 1", 21, new Address("house No. 1","street 1","city 1","111"));
        Customer c2 = new Customer("cust 2", 22, new Address("house No. 2","street 2","city 2","222"));
        Customer c3 = new Customer("cust 3", 23, new Address("house No. 3","street 3","city 3","333"));
        Customer c4 = new Customer("cust 4", 24, new Address("house No. 4","street 4","city 4","444"));
        Customer c5 = new Customer("cust 5", 25, new Address("house No. 5","street 5","city 5","555"));

        arrayList1.add(c1);
        arrayList1.add(c2);
        arrayList1.add(c3);
        //iteration through for loop
        System.out.println("Iterating through for loop : ");
        for (int i = 0; i < arrayList1.size(); i++) {
            Customer c = (Customer)arrayList1.get(i);
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }

        /**
         * We can use Iterator to traverse a Set or a List or a Map.
         */
        //iteration through iterator
        System.out.println("\nIterating through Iterator : ");
        Iterator itr = arrayList1.iterator();
        while(itr.hasNext()){
            Customer c = (Customer)itr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
            }

        /**
         * ListIterator can only be used to traverse a List, it can't traverse a Set.
         * ListIterator can :-
            1. iterate backwards/forward.
            2. obtain the index at any point.
            3. add a new value at any point.
            4. set a new value at that point.
         */
        //iteration through list iterator
        System.out.println("\nIterating through ListIterator : ");
        ListIterator<?> lItr = arrayList1.listIterator();
        lItr.hasPrevious();
        while(lItr.hasNext()){
            Customer c = (Customer) lItr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
            }
    }
}
