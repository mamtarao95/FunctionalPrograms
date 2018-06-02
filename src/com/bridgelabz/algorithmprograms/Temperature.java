/*******************************************************************************
 *  Purpose: This method converts temperature from Farenheit to Celsius and vice-versa
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;
import com.bridgelabz.util.Utility;

public class Temperature {
	public static void main(String[] args) {
		System.out.println("Enter your choice");
	    System.out.println("1: Celsius to Farenheit");
	    System.out.println("2: Farenheit to Celsius");
	    double res=Utility.temperatureConversion(Utility.userInputInteger());	
	    if(res==-1) {
	    	System.out.println("Enter valid choices!!");
	    }
	    System.out.println("Converted temperature is: "+res);
		
	}
	
	

}
