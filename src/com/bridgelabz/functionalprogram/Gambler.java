/******************************************************************************
 *  Purpose: Simulates a gambler who start with $stake and place fair $1 bets until
			he/she goes broke (i.e. has no money) or reach $goal.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Gambler {
	public static void main(String[] args) {
		System.out.println("enter the stake amount(in Rs): ");
		double stake =Utility.userInputDouble();
		System.out.println("enter the goal amount(in Rs): ");
		double goal = Utility.userInputDouble();
		System.out.println("enter the no. of plays: ");
		int plays = Utility.userInputInteger();
		Utility.gambling(stake, goal, plays);

	}

}
