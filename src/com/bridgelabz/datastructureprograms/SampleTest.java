package com.bridgelabz.datastructureprograms;

public class SampleTest {

	public static void main(String[] args) {
		LinkedStack<Integer> stk=new LinkedStack<Integer>();
		stk.push(1);
		stk.push(11);
		stk.push(55);
		stk.push(43);
		stk.display();
		System.out.println(stk.size());
		System.out.println(stk.isEmpty());
		
		System.out.println(stk.pop());
		System.out.println(stk.pop());
	
		stk.display();
		System.out.println(stk.size());

	}

}
