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
