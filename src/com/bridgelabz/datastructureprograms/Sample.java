package com.bridgelabz.datastructureprograms;

public class Sample {
	public static<T extends Comparable<T>> void main(String[] args) {
		
		   LinkedQueue<Integer> link = new LinkedQueue<Integer>();
		   link.enQueue(3);
		   link.enQueue(31);
		   link.enQueue(32);
		   System.out.println(link.isEmpty());
		   
		   link.displayQueue();
	
	}

}
