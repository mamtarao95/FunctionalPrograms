package com.bridgelabz.datastructureprograms;

public class SampleTest {

	public static void main(String[] args) {
		LinkedStack<Integer> stk=new LinkedStack<Integer>();
		stk.push(1);
		stk.push(11);
		stk.push(55);
		stk.push(43);
		System.out.println(stk.isEmpty());
		stk.display();
		stk.pop();
		stk.pop();
		stk.display();
		

	}

}
