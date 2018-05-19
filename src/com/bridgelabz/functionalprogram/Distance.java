/******************************************************************************
 *  Purpose: Program Distance.java that takes two integer command­line arguments x
			and y and prints the Euclidean distance from the point (x, y) to the origin (0, 0).
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Distance {
	public static void main(String[] args) {
		System.out.println("Enter the value of X: ");
		double x = Utility.userInputInteger();
		System.out.println("Enter the value of Y: ");
		double y =  Utility.userInputInteger();
        double distOrigin = Utility.calcEuclid(x,y);
		System.out.println("The euclid distance from origin(0,0) to point(" + x + "," + y + ") is: "+distOrigin);
	}

}
