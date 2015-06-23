package com.puzzle.a_3loopypuzzlers;

class BigDelight {
	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			System.out.println(b);
			if (b == 0x90)
				System.out.print("Joy!");
		}
	}
}
