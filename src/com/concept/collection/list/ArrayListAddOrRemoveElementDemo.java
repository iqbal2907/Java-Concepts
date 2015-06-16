/**
 * We should always use parameterized ArrayList. Raw type is not recommended
 * Just for explaining purpose I had used raw type ArrayList here.
 */
package com.concept.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class ArrayListAddOrRemoveElementDemo {
    public static void main(String[] args) {

        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();

        Customer c1 = new Customer("cust 1", 21, new Address("house No. 1","street 1","city 1","111"));
        Customer c2 = new Customer("cust 2", 22, new Address("house No. 2","street 2","city 2","222"));
        Customer c3 = new Customer("cust 3", 23, new Address("house No. 3","street 3","city 3","333"));
        Customer c4 = new Customer("cust 4", 24, new Address("house No. 4","street 4","city 4","444"));
        Customer c5 = new Customer("cust 5", 25, new Address("house No. 5","street 5","city 5","555"));

        /**
         * Concept 1 :
         * Adding/Removing element at some index will not remove that element
         * instead it shift the element towards right/left side.
         */
        arrayList1.add(c1);
        arrayList1.add(c1);
        arrayList1.add(c2);

        arrayList1.add(1, c2);  //Here check the concept
        arrayList1.add(2, c3);

        Iterator itrAL1 = arrayList1.iterator();
        while(itrAL1.hasNext()){
            Customer c = (Customer)itrAL1.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);

            }
        System.out.println("1 ********************************************************************\n");

        /**
         * Concept 2
         * java.util.ConcurrentModificationException will occur if we get Iterator from arraylist and then try to remove
         * any object. NOTE : We should remove/add in arraylist before getting Iterator
         */

        arrayList1 = null;
        arrayList1 = new ArrayList();
        arrayList1.add(c1);
        arrayList1.add(c2);
        arrayList1.add(c3);

        itrAL1 = arrayList1.iterator(); //NOTE : Iterator should be initialize since it reached to end in first while loop
//        arrayList1.remove(3);
//        arrayList1.remove(c1);
//        arrayList1.add(c4);
// All the above (commented)line will raise java.util.ConcurrentModificationException since we are modifying after fetching Iterator

        while(itrAL1.hasNext()){
            Customer c = (Customer)itrAL1.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }
        System.out.println("2 ********************************************************************\n");
        arrayList1.add(c3); //since iterator reached till end so adding element here will not raise exception

        /**
         * Concept 3 :
         * removeAll() will remove all the objects from arraylist2 which is present in arraylist1
         * addAll() will add all the objects into arraylist2 which is present in arraylist1
         */

        arrayList1 = null;
        arrayList1 = new ArrayList();
        arrayList1.add(c1);
        arrayList1.add(c2);
        arrayList1.add(c3);

        arrayList2.add(c4);
        arrayList2.add(c5);
        arrayList2.addAll(arrayList1);

        Iterator itrAL2 = arrayList2.iterator();
        while(itrAL2.hasNext()){
            Customer c = (Customer)itrAL2.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }
        System.out.println("3 ********************************************************************\n");

        arrayList2.removeAll(arrayList1);

        itrAL2 = arrayList2.iterator();
        while(itrAL2.hasNext()){
            Customer c = (Customer)itrAL2.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }
        System.out.println("4 ********************************************************************\n");

        //Removing through Iterator
        arrayList2 = null;
        arrayList2 = new ArrayList();
        arrayList2.add(c1);
        arrayList2.add(c2);
        arrayList2.add(c3);
        arrayList2.add(c4);
        arrayList2.add(c5);

        System.out.println("\n######################## Before Removing through Iterator ########################\n");
        Iterator Itr = arrayList2.iterator();
        while(Itr.hasNext()){
            Customer c = (Customer)Itr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }

        System.out.println("\n######################## Removing through Iterator ########################\n");
        itrAL2 = arrayList2.iterator();
        while(itrAL2.hasNext()){
            Customer c = (Customer)itrAL2.next();
            Address a = c.address;
            if(c.age==22){
                itrAL2.remove();
                continue;
            }
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }

        System.out.println("\n######################## After Removing through Iterator ########################\n");
        Iterator newItr1 = arrayList2.iterator();
        while(newItr1.hasNext()){
            Customer c = (Customer)newItr1.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }

        System.out.println("4 ********************************************************************\n");

        /**
         * Concept 4 :
         * addAll() will add all the objects into arraylist2 which is present in arraylist1 order will be maintained
         */

        arrayList1 = null;
        arrayList1 = new ArrayList();
        arrayList1.add(c1);
        arrayList1.add(c2);

        arrayList2 = null;
        arrayList2 = new ArrayList();

        arrayList2.add(c3);
        arrayList2.addAll(arrayList1);
        Iterator newItr = arrayList2.iterator();
        while(newItr.hasNext()){
            Customer c = (Customer)newItr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }
        System.out.println("5 ********************************************************************\n");

        /**
         * Concept 5 :
         * addAll(index, collection) will add all the objects into arraylist2 which is present in arraylist1 order will be maintained
         */

        arrayList1 = null;
        arrayList1 = new ArrayList();
        arrayList1.add(c1);
        arrayList1.add(c2);
        arrayList1.add(c3);

        arrayList2 = null;
        arrayList2 = new ArrayList();

        arrayList2.add(c4);
        arrayList2.add(c5);
        arrayList1.addAll(1, arrayList2);

        newItr = arrayList1.iterator();
        while(newItr.hasNext()){
            Customer c = (Customer)newItr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }
        System.out.println("6 ********************************************************************\n");

        /**
         * Concept 6 :
         *
         */

        arrayList1 = null;
        arrayList1 = new ArrayList();
        arrayList1.add(c1);
        arrayList1.add(c2);
        arrayList1.add(c3);

        arrayList2 = null;
        arrayList2 = new ArrayList();

        arrayList2.add(c4);
        arrayList2.add(c5);

        MyPredicate<Customer> filter;
//        filter = new MyPredicate<>();

//        filter.var1 = new ArrayListAddOrRemoveElementDemo().new Customer("cust 2", 22, new Address("house No. 2","street 2","city 2","222"));
//        arrayList1.removeIf(filter);

        newItr = arrayList1.iterator();
        while(newItr.hasNext()){
            Customer c = (Customer)newItr.next();
            Address a = c.address;
            System.out.println(" Name : "+c.name+" Age : "+c.age+" Address : "+a.ph+" "+a.hNo+" "+a.street+" "+a.city);
        }

    }

    class MyPredicate<T> implements Predicate<T>{
        T var1;
        @Override
        public boolean test(T var){
        if(var1.equals(var)){
         return true;
        }
        return false;
        }
      }

}
