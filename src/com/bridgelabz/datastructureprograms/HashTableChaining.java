package com.bridgelabz.datastructureprograms;

import java.util.Scanner;

class HashTableChaining {
	public static class SLLNode {
		SLLNode next;
		int data;

		public SLLNode(int x) {
			data = x;
			next = null;
		}

	}

	private static SLLNode[] table;
	private static int size;

	public HashTableChaining(int tableSize) {
		table = new SLLNode[nextPrime(tableSize)];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		int l = table.length;
		table = new SLLNode[l];
		size = 0;
	}

	public int getSize() {
		return size;

	}

	/* Function to insert an element */

	public static void insert(int val) {
		size++;
		int pos = myhash(val);
		SLLNode nptr = new SLLNode(val);
		if (table[pos] == null)
			table[pos] = nptr;
		else {
			nptr.next = table[pos];
			table[pos] = nptr;
		}
	}

	public static void remove(int val) {
		int pos = myhash(val);
		SLLNode start = table[pos];
		SLLNode end = start;

		if (start.data == val) {
			size--;
			table[pos] = start.next;
			return;
		}

		while (end.next != null && end.next.data != val)
			end = end.next;

		if (end.next == null) {
			System.out.println("\nElement not found\n");
			return;

		}

		size--;

		if (end.next.next == null) {
			end.next = null;
			return;
		}

		end.next = end.next.next;
		table[pos] = start;

	}

	/* Function myhash */

	public static int myhash(Integer x) {
		int hashVal = x.hashCode();
		hashVal %= table.length;
		if (hashVal < 0)
			hashVal += table.length;
		return hashVal;

	}

	/* Function to generate next prime number >= n */

	public static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2)
			;
		return n;

	}

	/* Function to check if given number is prime */

	public static boolean isPrime(int n) {

		if (n == 2 || n == 3)

			return true;

		if (n == 1 || n % 2 == 0)

			return false;

		for (int i = 3; i * i <= n; i += 2)

			if (n % i == 0)

				return false;

		return true;

	}

	public static boolean contains(int key)

	{

		for (int i = 0; i < table.length; i++)

		{
			SLLNode start = table[i];

			while (start != null)

			{

				if (start.data == key) {
					return true;
				}

				start = start.next;

			}

		}
		return false;

	}

	public static void printHashTable()

	{

		System.out.println();

		for (int i = 0; i < table.length; i++)

		{

			System.out.print("Bucket " + i + ":  ");

			SLLNode start = table[i];

			while (start != null)

			{

				System.out.print(start.data + " ");

				start = start.next;

			}

			System.out.println();

		}

	}

}
