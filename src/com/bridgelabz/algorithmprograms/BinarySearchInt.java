package com.bridgelabz.algorithmprograms;

import java.util.Arrays;

import com.bridgelabz.util.Utility;

public class BinarySearchInt {

	public static void main(String[] args) {

		System.out.println("Enter the size of array");
		int size = Utility.userInputInteger();
		Integer[] ar=new Integer[size];
		System.out.println("Enter the elements ");
		
		for (int i = 0; i < size; i++) {
			ar[i] = Utility.userInputInteger();
		}
		System.out.println("Enter the elements you want to search");
		int element = Utility.userInputInteger();
		Arrays.sort(ar);
		System.out.println("The sorted array is: ");
		for (int i = 0; i < size; i++) {
			System.out.println(ar[i]+", ");
		}
		long starttime=System.nanoTime();
		Utility.binSearchGenerics(ar, element);
		long elapsedtime=System.nanoTime()-starttime;
		System.out.println("The elapsed time for the searching operation is: "+elapsedtime+"ns");
	}
}
