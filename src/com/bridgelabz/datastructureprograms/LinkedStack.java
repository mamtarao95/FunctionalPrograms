package com.bridgelabz.datastructureprograms;

public class LinkedStack<T extends Comparable<T>>  {
    private Node<T> top = null;
	private int size = 0;
    LinkedList<T> linkedList=new LinkedList<>();
	public static class Node<T extends Comparable<T>> {
		private int top=0;
		private Node<T> next;
		public T data;
		
		public Node() {
			this.top=0;
			this.next=null;
		}
		
		public Node(T data) {
			this.data=data;
		}
		public T getData() {
			return data;
		}

	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int size() {
		return size;
	}
	
	
	public void push(T data) {
		//linkedList.add(data);

		Node<T> new_node=new Node<T>(data);
		if(top==null) {
			top=new_node;
		}
		else {
			new_node.next=top;
			top=new_node;
			}
		size++;
		}
	
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("underflow exception");
		}
		Node<T> temp=top;
			top=temp.next;
			size--;
		
		return temp.data;
		
		//return linkedList.removeAt(linkedList.getCount()-1);
	}
	
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("underflow exception");
			return null;
		}
		return top.data;
	}
	
	
	public void display() {
		//linkedList.display();
		System.out.println("Stack contains: ");
		
		if(size==0) {
			System.out.println("Empty stack!!");
			return;
		}
		
		Node<T> temp=top;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println();
	}
	
	

	public void displayCalender() {
		if(size==0) {
			System.out.println("Empty Queue");
			return;
		}
		Node<T> temp=top;
	
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
		
		Node<T> temp=top;
		while(temp!=null) {
			System.out.print(temp.getData());
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	



