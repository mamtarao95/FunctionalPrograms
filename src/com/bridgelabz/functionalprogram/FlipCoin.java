package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;
import java.util.Scanner;

public class FlipCoin

{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of tosses you want: ");
		/*
		 * variable stores the user input (times of flips of coins)
		 */
		int timesofflip=sc.nextInt();
		Utility utility=new Utility();
		if(timesofflip>0)
		utility.genPercentage(timesofflip);
		else
		System.out.println("Enter positive integer value!!");
		sc.close();
	}
}
