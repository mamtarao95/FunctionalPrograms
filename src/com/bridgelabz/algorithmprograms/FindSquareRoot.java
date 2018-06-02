/*******************************************************************************
 *  Purpose: This method generates square root using Newton Raphson's Method
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class FindSquareRoot {

		public static void main(String[] args) {
			System.out.println("Enter a non-negative number");
			double res=Utility.sqrt(Utility.userInputDouble());
			if(res==-1) {
				System.out.println("No roots");
			}
			System.out.println(res);
		   }
}
