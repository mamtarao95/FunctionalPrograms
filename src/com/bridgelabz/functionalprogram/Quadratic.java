/******************************************************************************
 *  Purpose:Program to find the roots of the equation a*x*x + b*x + c..
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Quadratic {
	public static void main(String[] args) {
		System.out.println("enter value of a:");
		double a = Utility.userInputDouble();
		System.out.println("Enter value of b:");
		double b =  Utility.userInputDouble();
		System.out.println("Enter value of c:");
		double c =  Utility.userInputDouble();
		double[] ar = Utility.findRoots(a, b, c);
		System.out.println("First root of the given equation is :"+ar[0]);
		System.out.println("Second root of the given equation is :"+ar[1]);
		}

}
