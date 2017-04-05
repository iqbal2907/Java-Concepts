package com.concept.stack;


public class TwoWayStackUsingArray {

	int arr[];
	int top1;
	int top2;
	
	
	public TwoWayStackUsingArray(int size) {
		super();
		this.arr = new int[size];
		this.top1 = -1;
		this.top2 = size;
	}
	
	void push1(int data){
		if (top1<top2-1) {
			top1++;
			arr[top1]=data;
		} else {
			System.out.println("Stack 1 overflow, Cannot add the element : "+data);
		}
	}

	void push2(int data){
		if (top1+1<top2) {
			top2--;
			arr[top2]=data;
		} else {
			System.out.println("Stack 2 overflow, Cannot add the element : "+data);
		}
	}
	
	int pop1(){
		int p1 = arr[top1];
		top1--;
		return p1;
	}

	int pop2(){
		int p2 = arr[top2];
		top2++;
		return p2;
	}
	
	int top1(){
		if (top1 == -1) {
			System.out.println("Stack 1 empty");
			return 0;
		} else {
			return arr[top1];
		}
	}
	
	int top2(){
		if (top2 == arr.length) {
			System.out.println("Stack 2 empty");
			return 0;
		} else {
			return arr[top2];
		}
	}

	void PrintStack1(){
		if (top1 !=-1) {
			for (int i = top1; i >= 0; i--) {
				System.out.println(arr[i]+" ");
			}			
		}
	}

	void PrintStack2(){
		for (int i = top2; i <= arr.length-1; i++) {
			System.out.println(arr[i]+" ");
		}
	}

	public static void main(String args[]){
		TwoWayStackUsingArray myArrayStack = new TwoWayStackUsingArray(12);
		myArrayStack.push2(1);
		myArrayStack.push2(2);
		myArrayStack.push2(3);
		myArrayStack.push2(4);
		myArrayStack.push2(5);
		myArrayStack.push2(6);
		myArrayStack.push2(7);
		myArrayStack.push2(8);
		myArrayStack.push2(9);
		myArrayStack.push1(10);
		
		myArrayStack.push1(29);

		
		System.out.println("Top1 is : "+myArrayStack.top1()+", At :"+ myArrayStack.top1);
		
		System.out.println("Elements in Stack 1");
		myArrayStack.PrintStack1();
		
//		myArrayStack.push2(19);
		System.out.println("Top2 is : "+myArrayStack.top2()+", At :"+ myArrayStack.top2);

		System.out.println("Elements in Stack 2");
		myArrayStack.PrintStack2();

	}
}
