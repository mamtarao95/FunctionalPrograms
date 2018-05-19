/******************************************************************************
 *  Purpose: Program to calculate wind chill based on two command line argument.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class WindChill {
	
	public static void main(String[] args) {
		double temp = Double.parseDouble(args[0]);
		double wind = Double.parseDouble(args[1]);

		if (Math.abs(temp) < 50 && wind > 3 && wind < 120) {
			double windChill = Utility.calcWindChill(temp, wind);
			System.out.println("The windchill is: " + windChill);
		} else
			System.out.println("Enter the valid values!!");
		}
}
