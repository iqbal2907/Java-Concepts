package com.puzzle.a_3loopypuzzlers;

public class CurseOfLooper {
    public static void main(String[] args) {
        // Place your declarations for i and j here
    	int i=0,j=0;
        while (i <= j && j <= i && i != j) {
        	System.out.println("inside while");
        }
    }
}
