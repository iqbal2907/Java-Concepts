package com.puzzle.a_7classierpuzzlers;
public class StrungOut {
    public static void main(String[] args) {
    	MyString s = new MyString("Hello world");
        System.out.println(s);
    }
}

class MyString {
    private final java.lang.String s;

    public MyString(java.lang.String s) {
        this.s = s;
    }

    public java.lang.String toString() {
        return s;
    }
}
