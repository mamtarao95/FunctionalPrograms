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
		for (int i = 0; i <= 1000; i++) {
			Utility.printPrime(i);
		}
		
	System.out.println("There are a total of " + Utility.TOTAL + " numbers of primenumber between 0-1000");
	
	}
	
}
