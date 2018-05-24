/******************************************************************************
 *  Purpose: Return all permutation of a given String.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class PermuteString{
	
	public static void main(String[] args){
		System.out.println("Enter the string");
	Utility.permutation(Utility.userInputString().toCharArray() , 0);
	System.out.println("number of permutations are "+Utility.permutationCount);
		
     }
}