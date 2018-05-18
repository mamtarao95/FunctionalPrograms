package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;

public class LeapYear{

	public static void main(String[] args) {
		System.out.println("Enter the year: ");
		int year=Integer.parseInt(Utility.userInputString());
	
		if(Utility.userInputString().length()==4 && year>=1528)
		{
			if(Utility.isLeap(year)) {
				System.out.println(year + " is a leap year!!");
			}
			else {
				System.out.println(year + " is not a leap year!!");
	    	}
	System.out.println("Enter valid year (4 digit and not less than 1528)!! ");

		}
	}
}