/******************************************************************************
 *  Purpose:Computes the prime factorization of N using brute force.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class PrimeFactors {
	public static void main(String[] args) {
		System.out.println("enter the number");
		Utility.findPrime(Utility.userInputInteger());
	}
}
