package com.jp.co.worksap.intern;

/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;

/**
 * @author Deepak
 * @param <E>
 *
 */
public class SortableStack<E extends Comparable<E>> implements ISortableStack<E> {

	private int N;          
    private Node first;     


    private class Node {
        private E e;
        private Node next;
    }


    public SortableStack() {
        first = null;
        N = 0;
    }


    private ArrayList<E> listOne = new ArrayList<E>();
    
    public boolean isEmpty() {
        return first == null;
    }
  
    
	public E Pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new RuntimeException("Stack underflow");
        E e = first.e;        // save e to return
        first = first.next;            // delete first node
        N--;
        listOne.remove(e);
        return e;                   // return the saved e
	}

	 public E peekMidElement() {
	        if(listOne.size() <= 0){
	        throw new EmptyStackException();
	        }

	        return listOne.get(listOne.size()/2);
	  }

	    @SuppressWarnings("unchecked")
		public E peekHighestElement() {
	        if(listOne.size() <= 0){
	        throw new EmptyStackException();
	        }
	        Object obj = Collections.max(listOne);
	        return (E) obj;
	       
	      }

	    @SuppressWarnings("unchecked")
		public E peekLowestElement() {
	        if(listOne.size() <= 0){
	        throw new EmptyStackException();
	        }
	        Object obj = Collections.min(listOne);
	        return (E) obj;
	     }

	public void push(E e) {
		// TODO Auto-generated method stub
		if(e==null)
			throw new NullPointerException();
		Node oldfirst = first;
        first = new Node();
        first.e = e;
        first.next = oldfirst;
        listOne.add(e);
        N++;
		
	}

	public int size() {
		return N;
	}
	
	
	public static void main(String []args)throws IOException{
	
		ISortableStack<Integer> s = new SortableStack<Integer>();
		System.out.print("Stack Example");
		//char character;
		int element;
		System.out.println("\n Enter number: ");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		//String str = br.readLine();
		
		int choice;
		do{
		System.out.println("1.Push\n2.Pop\n3.PeekMid\n4.PeekHighest\n5.PeekLowest\n6.Size\n7.Exit1");

        System.out.println("Enter your choice:");
        
        String str = br.readLine();
        choice = Integer.parseInt(str);
        
        
        switch(choice){
        
        case 1:
        	System.out.println("Enter Element: ");
        	str = br.readLine();
        	element = Integer.parseInt(str);
        	s.push(element);
        	break;
        	
        case 2:
        	int popElement = s.Pop();
        	System.out.println("Pop Element : " + popElement);
        	break;
        	
        case 3:
        	int midElement = s.peekMidElement();
        	System.out.println("Mid Element : " + midElement);
        	break;
        	
        case 4:
        	int highestElement = s.peekHighestElement();
        	System.out.println("Highest Element : " + highestElement);
        	break;
        	
        case 5:
        	int lowestElement = s.peekLowestElement();
        	System.out.println("Lowest Element : " + lowestElement);
        	break;
        case 6:
        	int len = s.size();
        	System.out.println("Size : " + len);
        	break;
        	
        }
        
		}while(choice!=7);
        	
	}

	

}
