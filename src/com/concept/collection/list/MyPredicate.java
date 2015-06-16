package com.concept.collection.list;

import java.util.function.Predicate;

public class MyPredicate<T> implements Predicate<T>{
      T var1;
      @Override
    public boolean test(T var){
      if(var1.equals(var)){
       return true;
      }
      return false;
      }
}