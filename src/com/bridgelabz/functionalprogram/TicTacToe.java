package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;
public class TicTacToe 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of rows:");
		int row1=sc.nextInt();
		System.out.println("Enter the numberof columns:");
		int col1=sc.nextInt();
		Utility utility=new Utility();
		utility.letsPlay(row1,col1);
		
		
		sc.close();
		
	}

}
