/******************************************************************************
 *  Purpose: Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Harmonic {
	public static void main(String[] args) {
		double res = Utility.findHarmonic(Utility.userInputInteger());
		System.out.println("the harmonic number is :" + res);
	}
}
