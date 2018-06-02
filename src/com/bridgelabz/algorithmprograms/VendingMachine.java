/*******************************************************************************
 *  Purpose: This method generates possible denomination of the given currency
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class VendingMachine {
	public static void main(String[] args) {
		System.out.println("Please enter the number(in rs) ");
		int countOfNotes=Utility.generateChange(Utility.userInputInteger());
		System.out.println("The minimum no. of notes possible is "+countOfNotes);
	}

}
