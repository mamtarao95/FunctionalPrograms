/*******************************************************************************
 *  Purpose: This method performs binary nibbles swap
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class BinarySwapNibble {
	public static void main(String[] args) {
		System.out.println("Enter the decimal number:");
		int binary=Utility.binary(Utility.userInputInteger());
		if(binary!=-1)
		System.out.println("The binary representation of swapped number is: "+binary);
		else
		System.out.println("Enter number in the range -128 to +127 ");
		}
	}
