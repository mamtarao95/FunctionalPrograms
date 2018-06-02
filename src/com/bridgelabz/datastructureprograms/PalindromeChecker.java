/*******************************************************************************
 *  Purpose: This method checks for pallindrome
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class PalindromeChecker {
	public static void main(String[] args) {
		System.out.println("Enter the string to check for pallindrome ");
		String inputString=Utility.userInputString();
		Utility.pallindromeDeque(inputString);
	}
	

}
