/*******************************************************************************
 *  Purpose: This method performs binary search on strings
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import java.util.Arrays;
import com.bridgelabz.util.Utility;

public class BinarySearchString {
	
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		int size = Utility.userInputInteger();
		String[] ar = new String[size];
		System.out.println("Enter the elements");
		
		for(int i=0; i<size; i++) {
			ar[i] = Utility.userInputString();
			}
		
		System.out.println("Enter the element you want to search");
		String element = Utility.userInputString();
		
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
