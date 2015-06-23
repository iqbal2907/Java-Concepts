package com.puzzle.a_3loopypuzzlers;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
    	int i=1;
        while (i != 0){
        	System.out.println(i);
            i >>>= 1;
            System.out.println(i);
        }
    }
}
