/******************************************************************************
 *  Purpose: Program to play tic-tac-toe game between two players
 *   		player 1 is computer and player 2 is user
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class TicTacToe {
	public static void main(String[] args) {
		System.out.println("enter the number of rows in board:");
		int row1 = Utility.userInputInteger();
		System.out.println("Enter the numberof columns in board:");
		int col1 = Utility.userInputInteger();
		Utility.letsPlay(row1, col1);
	}
}
