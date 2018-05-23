package com.bridgelabz.datastructureprograms;

public class LinkedList {

	class Node {
		public Object data;
		public Node next;
		
		public Node(Object data) {
			this.data=data;
		}
		public Node head=null;
		public int size=0;
		
		public void add(Object data) {
			Node n1=new Node(data);
			if(head==null) {
				head=n1;
				size++;
				return;
			}
			Node temp=head;
			while(temp.next!=null) {
				temp=(Node)temp.next;
				
			}
			temp.next=n1;
			size++;
		}
		
		public void addFirst(Object data) {
			Node n1=new Node(data);
			n1.next=head;
			head=n1;
			size++;
		}
		
		public void display() {
			if(size==0) {
				System.out.println("Empty");
				return;
			}
			Node temp=head;
			while(temp!=null) {
				System.out.println("Data: "+temp.data);
				temp=(Node)temp.next;
			}
		}
		
		public void addAt(Object data,int index) {
			if(index==0) {
				addFirst(data);
				return;
			}
			Node n1=new Node(data);
			int count=0;
			Node temp=head;
			while(count<index-1) {
				temp=(Node)temp.next;
				count++;
			}
			n1.next=temp.next;
			temp.next=n1;
			size++;
		}
		
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size==0;
		}
		public Object removeAt(int index) {
			if(index==0) {
				Object temp=head.data;
				head=(Node)head.next;
				size--;
				return temp;
			}
			Node t=head;
			int count=0;
			while(count<index-1) {
				t=(Node)t.next;
				count++;
			}
			Object temp=t.next.data;
			t.next=t.next.next;
			size--;
			return temp;
		}
		
		public Object removeFirst() {
			Object temp=head.data;
			head=(Node)head.next;
			size--;
			return temp;
		}
		
		public void reverse(Node start) {
			if(start.next!=null) {
				reverse(start.next);
			}
		}
		
		public void reverse() {
			reverse(head);
		}
		
		public void displayMid() {
			Node mid=head;
			int count=0;
			while(count!=size/2) {
				mid=mid.next;
				count++;
			}
			System.out.println(mid.data);
		}
			
		}

		

	
}
