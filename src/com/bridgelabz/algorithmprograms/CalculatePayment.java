/*******************************************************************************
 *  Purpose: This method to calculate monthly payment compounded monthly
 *  
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class CalculatePayment {
	
	public static void main(String[] args) {
		double principal=Double.parseDouble(args[0]);
		double year=Double.parseDouble(args[1]);
		double rate=Double.parseDouble(args[2]);
		double res=Utility.monthlyPayment(principal,year,rate);
		System.out.println("The monthly payment amount to be made is: "+res);
	}

}
