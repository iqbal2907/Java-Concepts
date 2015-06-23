package com.puzzle.a_7classierpuzzlers;
class Base {
    public String className = "Base";
}

class Derived extends Base {
    String className = "Derived";
}

public class PrivateMatter {
    public static void main(String[] args) {
        System.out.println(new Derived().className);
    }
}
