/******************************************************************************
 *  Purpose: Program to Flip Coin and print percentage of Heads and Tails.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class FlipCoin {
public static void main(String[] args) {
		System.out.println("Enter the number of tosses you want: ");
			Utility.genPercentage(Utility.userInputInteger());
		}
	}

