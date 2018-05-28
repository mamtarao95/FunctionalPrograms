package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructureprograms.LinkedStack.Node;

public class LinkedDequeue<T extends Comparable<T>> {
	private T data;
	private Node<T> front,rear;
	private int size=0;
	
	public static class Node<T extends Comparable<T>> {
		private Node<T> next;
		public T data;
		
		public Node() {
			this.data=null;
			this.next=null;
		}
		
		public Node(T data) {
			this.data=data;
			//this.next=next;
		}
		
		public T getData() {
			return data;
		}
	}
	
	public void dequeue() {
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
	
	
	
	public void erase() {
		front=null;
		rear=null;
		size=0;
		
	}
	
	public void insertAtFront(T data) {
		Node<T> new_node= new Node<T>(data);
		if(front==null) {
			front=new_node;
			rear=front;
		}
		else {
			new_node.next=front;
			front=new_node;
		}
		size++;
	}
	
	
	public void insertAtRear(T data) {
		Node<T> new_node= new Node<T>(data);
		
		if(rear==null && front==null) {
			rear=new_node;
			front=rear;
		}
		else {
			rear.next=new_node;
			rear= new_node;
			}
		size++;
	}
	
	
	public T removeAtFront() {
		if(isEmpty()) {
			System.out.println("Empty queue!!");
			return null;
		}
		
			Node<T> temp=front;
			front=temp.next;
		
		if(front==null) 
			rear=null;
		
		size--;
		return temp.data;
	}
	
	
	public T removeAtRear() {
		if(isEmpty()) {
			System.out.println("Empty queue!!");
			}
		T element=rear.getData();
		Node s=front;
		Node t=front;
		while(s!=rear) {
			t=s;
			s=s.next;
		}
		rear=t;
		rear.next=null;
		size--;
		return element;
	}
		
	public void displayDequeue(){
		if (size == 0) {
			System.out.println("Empty Dequeue");
			return;
		}
		Node<T> temp = front;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.next;
		}
	}
		public void displayDequeueat(){
			if (size == 0) {
				System.out.println("Empty Dequeue");
				return;
			}
			Node<T> temp = rear;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.next;
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	


