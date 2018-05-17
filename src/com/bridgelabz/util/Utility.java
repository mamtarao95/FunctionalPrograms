package com.bridgelabz.util;
import java.util.Scanner;

public class Utility
{
	Scanner sc=new Scanner(System.in);
	
	/*
	 * Method to replace the a string with the user input name
	 *  
	 * @param String to take reference to replace user name
	 * @return modified string which contains user name
	 */
	public String replaceUserName(String temp)
	{
		System.out.println("Enter your name: ");
		/*
		 * String variable to store the user name taken as input from user
		 */
		String name=sc.next();
		
		/*
		 *String  variable to store the modified string
		 */
		String res=temp.replace("<<username>>",name);
		sc.close();
		
		
		return res;
	    	
	}
	
	
	/*
	 * Method to calculate percentage of head vs tail in the given number of trials
	 * 
	 *  @param int to give reference of no. of trials
	 */
	public void genPercentage(int timesofflip)
	
	{
		/*
		 * initialise variables
		 */
		float head=0;
		float tail=0;
		float headPercent;
		float tailPercent;
		for(int i=0 ; i<timesofflip ; i++)
		  {
		   double flip=Math.random();
		      if(flip<=0.5)
		        head++;
		      else
		        tail++;
		  }

		headPercent= ((head/timesofflip))*100;
		tailPercent= ((tail/timesofflip))*100;
		System.out.println("number of times head appeared: " + head);
		System.out.println("number of times tail appeared: " + tail);
		System.out.println("head percentage: "+ headPercent+"%");
		System.out.println("tail percentage: "+ tailPercent+"%");
	}
	
	/*
	 * Method to check whether the given year is leap year or not
	 */
	
	public boolean isLeap(int year)
	{
		
		if(year%4==0) {
			if(year%100==0){  
			if(year%400==0) {
			           
			return true;
				  
			 }
			else
			{
			return false;
			}}
			 
			else
			{
				return true;
			}}

		
			else{
				return false;
				}
		
	}
	
	
	/*
	 * Method to print each power of two
	 */
	public void printPower(int power)
	{
	System.out.println("The table of power of 2 till "+ power+ ": ");
	  
	/*
	 * Loop to print each power of two
	 */
	for(int i=1;i<=power;i++)
	   {
	     int res=twoPower(i);
	      System.out.println("2^"+i+"= "+res);
       }

	}
	
	/*
	 * method to find power of two for each number//
	 */
	public int twoPower(int i)
	{
	int temp=1;
	   for(int x=1;x<=i;x++)
	     {
	      temp=temp*2;
	      }
	return temp;
    }

	/*
	 * Method to take 2D array elements in integer,double 
	 * or string type from user and store it in memory
	 */
	public double[][] arrayElement()
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter number of rows");
	int m=sc.nextInt();
	System.out.println("enter number of columns");
	int n=sc.nextInt();
	/*
	 * double two dimensional array variable
	 */
	double[][] ar=new double[m][n];
	System.out.println("enter "+(m*n)+" elements of the 2D array: ");
	for(int i=0 ; i<ar.length ; i++)
	{
		for(int j=0 ; j<ar[i].length; j++)
		{

			System.out.print("enter ar["+i+"]["+j+"] = " );
			ar[i][j]=sc.nextDouble();
		}
	}
	sc.close();
	return ar;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
	}


