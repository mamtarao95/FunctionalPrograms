package com.bridgelabz.datastructureprograms;


public class SortedLinkedList<T extends Comparable<T>> {

	public static class Node<T extends Comparable<T>> {
		private T Comparable_data;
		private Node<T> Comparable_next;

		public Node(T data, Node<T> next) {
			this.Comparable_data = data;
			this.Comparable_next = next;
		
		}

		public Node(T data) {
			this.Comparable_data = data;

		}

		public T getValue() {
			return Comparable_data;
		}

		public int compareTo(Object object) {
			return 0;
		}
	}
	
	public void add(T data) {
		
	}
	
	
	
	
	
	}




	


