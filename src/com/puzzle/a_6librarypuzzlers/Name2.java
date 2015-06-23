package com.puzzle.a_6librarypuzzlers;
import java.util.*;

public class Name2 {
    private String first, last;

    public Name2(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Name2))
            return false;
        Name2 n = (Name2)o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Name2> s = new HashSet<Name2>();
        s.add(new Name2("Mickey", "Mouse"));
        System.out.println(
            s.contains(new Name2("Mickey", "Mouse")));
    } 
}
