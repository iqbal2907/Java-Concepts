package com.puzzle.a_4exceptionalpuzzlers;


public class Arcane1 {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world");
        } catch(Exception e) {
            System.out.println("I've never seen println fail!");
        }
    }
}
