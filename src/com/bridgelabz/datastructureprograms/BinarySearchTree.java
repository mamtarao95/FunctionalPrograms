package com.bridgelabz.datastructureprograms;

public class BinarySearchTree<T extends Comparable<T>> {
	private BSTNode<T> root;
	public static class BSTNode<T extends Comparable<T>> {
		private BSTNode<T> left, right;
		private T data;

		public BSTNode() {
			left = null;
			right = null;
			data = null;
		}

		public BSTNode(T data){
			left = null;
			right = null;
			this.data =data;
		}

		public void setLeft(BSTNode<T> node){
			left = node;
			}

	
		public void setRight(BSTNode<T> node){
			right = node;
		}

		/* Function to get left node */

		public BSTNode<T> getLeft(){
			return left;
		}

		/* Function to get right node */

		public BSTNode<T> getRight(){
			return right;
		}

		/* Function to set data to node */

		public void setData(T data){
			this.data = data;
			}

		/* Function to get data from node */
		public T getData(){
			return data;
		}

	}

	
	/* Constructor */
	public BinarySearchTree(){
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty(){
		return root == null;
	}

	/* Functions to insert data */
	public void insert(T data){
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private BSTNode<T> insert(BSTNode<T> node, T data){
		if (node == null)
			node = new BSTNode<T>(data);
		else{
			if (data.compareTo(node.getData())<=0)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
			}
		return node;

		}

}

