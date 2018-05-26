/******************************************************************************
 *  Purpose: This method allows Binary Search for integer values
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
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
		
		Arrays.sort(ar);
		System.out.println("The sorted array is: ");
		
		for (int i = 0; i < size; i++) {
			System.out.println(ar[i]+", ");
		}
		
		System.out.println("Enter the elements you want to search");
		long starttime=System.nanoTime();
		Utility.binSearchGenerics(ar, Utility.userInputInteger());
		long elapsedtime=System.nanoTime()-starttime;
		System.out.println("The elapsed time for the searching operation is: "+elapsedtime+"ns");
	}
}
