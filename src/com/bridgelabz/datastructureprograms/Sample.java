package com.bridgelabz.datastructureprograms;

public class Sample {
	public static<T extends Comparable<T>> void main(String[] args) {
		
		   LinkedDequeue<Integer> linkedDequeue = new LinkedDequeue<Integer>();
		   linkedDequeue.insertAtFront(3);
		   linkedDequeue.insertAtFront(31);
		   linkedDequeue.insertAtFront(33);
		   linkedDequeue.insertAtRear(66);
		   linkedDequeue.insertAtRear(77);
		   
		   linkedDequeue.displayDequeue();
		   System.out.println("..................");
		 int res=  linkedDequeue.removeAtFront();
		 System.out.println(res);
		 int res1=  linkedDequeue.removeAtFront();
		 System.out.println(res1);
		   System.out.println("..................");
		  linkedDequeue.displayDequeue();
	}

}
