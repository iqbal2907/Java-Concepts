package com.puzzle.a_5classypuzzlers;
public class Creator {
	public static void main(String[] args) {

		for (int i = 0; i < 100; i++)
			new Creatures();
        System.out.println(Creatures.numCreated());
    }
}

class Creatures {
	private static long numCreated = 0;

	public Creatures() {
		numCreated++;
	}

	public static long numCreated() {
		return numCreated;
	}
}
