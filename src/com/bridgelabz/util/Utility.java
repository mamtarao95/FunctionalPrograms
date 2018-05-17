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
	
}
