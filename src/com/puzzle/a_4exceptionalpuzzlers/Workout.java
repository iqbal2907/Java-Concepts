package com.puzzle.a_4exceptionalpuzzlers;

public class Workout {
    public static void main(String[] args) {
        workHard();
        System.out.println("It's nap time.");
    }

    private static void workHard() {
    	int i=0;
    	i++;
        try {
        	System.out.println(i);
            workHard();
        } finally {
            workHard();
        }
    }
}
