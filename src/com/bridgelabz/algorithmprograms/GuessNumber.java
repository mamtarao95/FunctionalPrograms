/******************************************************************************
 *  Purpose: ­> Purpose to guess the number through binary search.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class GuessNumber {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int N = (int) Math.pow(2, n);
		System.out.println("Think of an integer between " + 0 + "and " + (N - 1));
		int secret = Utility.guessGame(0, N-1);
		System.out.println("Your number is " + secret);
	}

}