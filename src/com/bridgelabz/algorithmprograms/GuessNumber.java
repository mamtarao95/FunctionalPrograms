package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class GuessNumber {

	public static void main(String[] args) {
		int res=Utility.guessGame(Integer.parseInt(args[0]));
		if ( res== -1)
			System.out.println("number not present");
		else
			System.out.println("number is " +res);
		
		}
	}
