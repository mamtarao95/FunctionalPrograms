package com.bridgelabz.datastructureprograms;

/**
 * @author administrator
 *
 * @param <T>
 */
class LinkedList<T extends Comparable<T>> {
	public static class Node<T extends Comparable<T>> {
		T data;
		Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data=data;
			this.next=next;
		}
		
		public Node(T data) {
			this.data=data;
			
		}
		
		public T getValue() {
			return data;
		}

		public int compareTo(Object object) {
			return 0;
		}

		

}
Node<T> head=null;
	int size=0;
		
		public void add(T data) {
			Node<T> new_node=new Node<T>(data);
			if(head.compareTo(null)==0) {
				head=new_node;
				size++;
				return;
			}
			
			Node<T> temp=head;
			while(temp.next!=null) {
				temp=(Node<T>)temp.next;
				
			}
			temp.next=new_node;
			size++;
		}
		
		
		/**
		 * Method to add element at first of linked list
		 */
		public void addFirst(T data) {
			Node<T> new_node=new Node<T>(data);
			new_node.next=head;
			head=new_node;
			size++;
		}
		
		/**
		 * Method to add element after the previous node of linked list
		 */
		public void insertAfter(T data,T reference)
		{
		   Node<T> temp = head;
		   while(temp != null && !temp.data.equals(reference)) {
			   temp = temp.next;
		   }

		   if(temp != null)
		      temp.next = new Node<T>(data, temp.next);
		}
	
		
		/**
		 * Method to add element at the last node of linked list
		 */
		public void addLast(T data){
		   if(head == null) {
			   addFirst(data);
		   }
		   else{
		      Node<T> temp = head;
		      while(temp.next != null) {
		    	  temp = temp.next;
		      }
		      	temp.next = new Node<T>(data, null);
		      	size++;
		   }
		}
		
		
		
		/**
		 * Method to display linked list
		 */
		public void display() {
			if(size==0) {
				System.out.println("Empty");
				return;
			}
			Node<T>temp=head;
			while(temp!=null) {
				System.out.println("Data: "+temp.data);
				temp=temp.next;
			}
		}
		
		
		 /**
		  * Method to search the element in a linked list
		 * @param value
		 * @return
		 */
		public boolean search(T value) {
		        Node<T> temp = head;  
		        while (temp != null)
		        {
		            if (temp.data.compareTo(value)==0)
		                return true; 
		           temp=temp.next;
		        }
		        return false;   
		    }
		
		/**
		 * Method to find size
		 */
		public int getCount(){
	        Node<T> temp = head;
	        int count = 0;
	        while (temp != null)
	        {
	            count++;
	            temp = temp.next;
	        }
	        return count;
	    }
		
		/**
		 * Method to check whether list is empty or not
		 */
		public boolean isEmpty() {
			return size==0;
		}
		
		
		/**
		 * Method to remove element at index
		 */
		public Object removeAt(int index) {
			if(index==0) {
				T temp=head.data;
				head=(Node<T>)head.next;
				size--;
				return temp;
			}
			Node<T> t=head;
			int count=0;
			while(count<index-1) {
				t=(Node<T>)t.next;
				count++;
			}
			Object temp=t.next.data;
			t.next=t.next.next;
			size--;
			return temp;
		}
		
		
		
		public Object removeFirst() {
			Object temp=head.data;
			head=(Node<T>)head.next;
			size--;
			return temp;
		}
		
		public void reverse(Node<T> start) {
			if(start.next!=null) {
				reverse(start.next);
			}
		}
		
		public void reverse() {
			reverse(head);
		}
		
		public void displayMid() {
			Node<T> mid=head;
			int count=0;
			while(count!=size/2) {
				mid=mid.next;
				count++;
			}
			System.out.println(mid.data);
		}
			
		}




