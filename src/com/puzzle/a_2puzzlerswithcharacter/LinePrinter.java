package com.puzzle.a_2puzzlerswithcharacter;

public class LinePrinter {

public static void main(String[] args) {
    // Note: \u000A //is Unicode representation of linefeed (LF)
    char c = 0x000A;
    
    System.out.print("Hello");
    System.out.print(c);
    System.out.print("World");
  } 
}
