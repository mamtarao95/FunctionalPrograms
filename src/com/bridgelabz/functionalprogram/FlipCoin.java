package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;

public class FlipCoin{
	
	public static void main(String[] args) {
		System.out.println("Enter the number of tosses you want: ");
		
		if(Utility.userInputInteger()>0)
		{
		Utility.genPercentage(Utility.userInputInteger());
		}
		else
		{
		System.out.println("Enter positive integer value!!");
		}
	}
}
