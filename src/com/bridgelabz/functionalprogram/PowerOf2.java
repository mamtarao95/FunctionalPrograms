/******************************************************************************
 *  Purpose: This program takes a command­line argument N and prints a table of the
			powers of 2 that are less than or equal to 2^N.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/

package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class PowerOf2{

	public static void main(String[] args){
		System.out.println("Enter the power value N (2^N): ");
		Utility.printPower(Utility.userInputInteger());
	}
	
}
