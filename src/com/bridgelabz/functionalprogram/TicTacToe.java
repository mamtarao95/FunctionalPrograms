package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class TicTacToe 
{
	public static void main(String[] args)
	{
		System.out.println("enter the number of rows in board:");
		int row1=Utility.userInputInteger();
		System.out.println("Enter the numberof columns in board:");
		int col1=Utility.userInputInteger();
		Utility.letsPlay(row1,col1);
		
		
		
		
	}

}
