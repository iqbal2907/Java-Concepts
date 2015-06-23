package com.puzzle.a_5classypuzzlers;
public class MyThing extends Thing {
    private static int arg;

    /*
     * This constructor is illegal. Rewrite it so that it has the same
     * effect but is legal.
     */
    public MyThing() {
        super(arg = (int)System.currentTimeMillis());
    }
}
