/******************************************************************************
 *  Purpose: Program to check whether a given year is leap year or not.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class LeapYear {
 
	public static void main(String[] args) {
		System.out.println("Enter the year: ");
		String result=Utility.checkLeapYear(Utility.userInputString());
		System.out.println(result);
		}
}