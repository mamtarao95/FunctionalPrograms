package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class PalindromeChecker {
	public static void main(String[] args) {
		System.out.println("Enter the string to check for pallindrome ");
		String inputString=Utility.userInputString();
		Utility.pallindromeDeque(inputString);
	}
	

}
