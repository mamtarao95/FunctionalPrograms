package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;
import java.util.Scanner;

public class LeapYear
{
	public static void main(String[] args)
	{
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the year: ");
	/*
	 * Variable takes input in form of string and stores it
	 */
	String inp=sc.next();
	
	/*
	 * Variable stores the year after converting into integer
	 */
	int year=Integer.parseInt(inp);
	
	/*
	 * Check the number of digit is 4  and it is greater than 1528
	 */
	if(inp.length()==4 && year>=1528)
	{
	Utility utility=new Utility();
	     if(utility.isLeap(year))
	     {System.out.println(year + " is a leap year!!");}
	     else
	     System.out.println(year + " is not a leap year!!");
	}
		
	else
	{
	System.out.println("Enter valid year (4 digit and not less than 1528)!! ");}
	}
	
	

}


