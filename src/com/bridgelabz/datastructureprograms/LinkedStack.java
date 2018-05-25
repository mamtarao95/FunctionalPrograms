package com.bridgelabz.datastructureprograms;

public class LinkedStack<T extends Comparable<T>>  {
    private Node<T> top = null;
	private int size = 0;
	private Node<T> temp;
	public static class Node<T extends Comparable<T>> {
		private int top=0;
		private Node<T> next;
		public T data;
		
		public Node() {
			this.top=0;
			this.next=null;
		}
		
		public Node(T data,Node<T> next) {
			this.data=data;
			this.next=next;
		}
		
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(T data) {
		Node<T> new_node=new Node<T>(data,null);
		if(top==null) {
			top=new_node;
		}
		else {
			new_node.next=top;
			top=new_node;
			}
		size++;
		
}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("underflow exception");
		}
		else {
			Node<T> temp=top;
			top=temp.next;
			size--;
		}
	}
	
	
	public T peek() {
		if(isEmpty()) {
			System.out.println("underflow exception");
			return null;
		}
		return top.data;
	}
	
	public void display() {
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
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	



