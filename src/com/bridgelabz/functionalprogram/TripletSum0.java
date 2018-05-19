/******************************************************************************
 *  Purpose: A program with cubic running time. Read in N integers and counts the
			number of triples that sum to exactly 0.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/

package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class TripletSum0 {
	public static void main(String[] args) {
		System.out.println("Enter the number of integers you want in the array: ");
		Utility.sumTriplet(Utility.userInputInteger());
		}
}
