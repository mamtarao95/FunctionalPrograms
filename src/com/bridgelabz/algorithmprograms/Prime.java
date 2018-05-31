/******************************************************************************
 *  Purpose: To print prime numbers in the range 0-1000
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class Prime {

	public static void main(String[] args) {
	int[] array = Utility.printPrime();
		for (int i = 0;i<array.length; i++) {
			System.out.println(array[i]);
			}
	System.out.println("There are a total of " + Utility.TOTAL + " numbers of primenumber between 0-1000");
	
	}
	
}
