package com.bridgelabz.datastructureprograms;

public class LinkedQueue<T extends Comparable<T>>  {
    private Node<T> front,rear;
	private int size = 0;
	
	LinkedList<Integer> list=new LinkedList<Integer>();
	public static class Node<T extends Comparable<T>> {
		private Node<T> next;
		public T data;
		
		public Node() {
			this.next=null;
		}
		
		public Node(T data) {
			this.data=data;
		}
		
		public T getData() {
			return data;
		}
		
	}
	
	public void linkedQueue() {
		front=null;
		rear=null;
		size=0;
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public int getSize() {
		return size;
	}
	
	
	public void enQueue(T data) {
		Node<T> new_node=new Node<T>(data);
		if(rear==null && front==null) {
			front=new_node;
			rear=new_node;
		}
		else {
			rear.next=new_node;
			rear=new_node;
		}
		//list.add((Integer) data);
		size++;
	}
	
	
	public T deQueue() {
		if(isEmpty()) {
			System.out.println("Underflow exception!! Deletion not possible");
			}
		Node<T> temp= front;
		front=temp.next;
		if(front==null) {
			rear=null;
			}
			size--;
			return temp.getData();
		}
		
	
	
	public T peek() {
	if(isEmpty()) {
		System.out.println("Underflow exception!!");
		return null;
	}
		return front.getData();
    }
	
	
	public void displayQueue() {
		if(size==0) {
			System.out.println("Empty Queue");
			return;
		}
		
		Node<T> temp=front;
		while(temp!=null) {
			System.out.println(temp.getData());
			temp=temp.next;
		}
		System.out.println();
	}
		

	public void displayCalender() {
		if(size==0) {
			System.out.println("Empty Queue");
			return;
		}
		Node<T> temp=front;
	
		for(int i=0;i<6;i++){
         for(int j=0;j<7;j++){
        	 
        	 if(temp!=null) {
        	 System.out.print(temp.getData()+" ");
        	temp=temp.next;}
        	}
         System.out.println();
	}

	}
		
	
	public void displayInLine() {
		if(size==0) {
			System.out.println("Empty Queue");
			return;
		}
		
		Node<T> temp=front;
		while(temp!=null) {
			System.out.print(temp.getData());
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	}	
	

	
