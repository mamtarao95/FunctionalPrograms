package com.bridgelabz.datastructureprograms;

public class LinkedStack<T extends Comparable<T>>  {
    private Node<T> top;
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
	
	
	/**
	 * Method to check whether stack is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() {
		return top==null;
	}
	
	
	/**
	 * Method to return size
	 * @return
	 */
	public int size() {
		return size;
	}
	
	
	
	/**
	 * Method to push data to the stack
	 * @param data
	 */
	public void push(T data) {
		linkedList.addFirst(data);
		size++;

		/*Node<T> new_node=new Node<T>(data);
		if(top==null) {
			top=new_node;
		}
		else {
			new_node.next=top;
			top=new_node;
			}
		size++;
		}
	*/
	}
	
	

	/**
	 * Method to pop data to the stack
	 * @param data
	 */
	public T pop() {
		/*if(isEmpty()) {
			System.out.println("underflow exception");
		}
		Node<T> temp=top;
			top=temp.next;
			size--;
		
		return temp.data;*/
		size--;
		return linkedList.removeAt(0);
		
	}
	
	
	
	/**
	 * Method to return the top value
	 * @return top
	 */
	public T peek() {
		if(isEmpty()) {
			System.out.println("underflow exception");
			return null;
		}
		return top.data;
	}
	
	
	/**
	 * Method to display linked list
	 */
	public void display() {
		linkedList.display();
	
}
	
	/**
	 * Method to display calender in a zig zag manner
	 * 
	 */
	public void displayCalender() {
		linkedList.displayCalender();
}
		
	
	
	/**
	 * Method to display linked list horizontally
	 */
	public void displayInLine() {
		linkedList.displayInLine();
}
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	



