package com.puzzle.a_6librarypuzzlers;
import java.util.*;

public class Name1 {
    private String first, last;

    public Name1(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name1))
            return false;
        Name1 n = (Name1)o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Name1> s = new HashSet<Name1>();
        s.add(new Name1("Mickey", "Mouse"));
        System.out.println(
            s.contains(new Name1("Mickey", "Mouse")));
    } 
}
