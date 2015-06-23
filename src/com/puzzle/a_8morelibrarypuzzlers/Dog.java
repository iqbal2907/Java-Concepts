package com.puzzle.a_8morelibrarypuzzlers;
public class Dog extends Exception {
    public static final Dog INSTANCE = new Dog();
    Dog() { }

    public String toString() {
        return "Woof";
    }
}
