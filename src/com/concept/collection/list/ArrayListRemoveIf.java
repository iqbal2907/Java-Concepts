package com.concept.collection.list;

import java.util.*;

public class ArrayListRemoveIf{
     public static void main(String args[]){
      ArrayList<Integer> myList;
      MyPredicate<Integer> filter;
      
      myList = new ArrayList<> ();
      filter = new MyPredicate<> ();
      
      filter.var1 = 10;
      
      /* Add Elements to myList */
      myList.add(10);
      myList.add(20);
      myList.add(10);
      myList.add(30);
      myList.add(10);
      myList.add(40);
      myList.add(10);
      
      System.out.println("Elements in myList are");
      System.out.println(myList);
      
      System.out.print("Removing all 10's from myList");
      System.out.println(myList.removeIf(filter));
      
      System.out.println("Elements in myList are");
      System.out.println(myList);
     }
}
