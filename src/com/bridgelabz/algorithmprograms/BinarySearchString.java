package com.bridgelabz.algorithmprograms;

import java.util.Arrays;

import com.bridgelabz.util.Utility;

public class BinarySearchString {
	
	public static void main(String[] args) {

		System.out.println("Enter the size of array");
		int size = Utility.userInputInteger();
		String[] ar = new String[size];
		System.out.println("Enter the string elements");
		
		for (int i = 0; i < size; i++) {
			ar[i] = Utility.userInputString();
		}
		System.out.println("Enter the string you want to search");
		String element = Utility.userInputString();
		
		Arrays.sort(ar);
		long starttime=System.nanoTime();
		int result = Utility.binSearchStr(ar, element);
		long elapsedtime=System.nanoTime()-starttime;
		
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
		System.out.println("The elapsed time for the searching operation is: "+elapsedtime+"ns");
	}
	

}
