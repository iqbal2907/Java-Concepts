package com.puzzle.a_4exceptionalpuzzlers;

public class Indecisive { 
    public static void main(String[] args) {
        System.out.println(decision());
    }

    static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    } 
}
