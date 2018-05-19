/******************************************************************************
 *  Purpose: A library for reading in 2D arrays of integers, doubles, or booleans from
			standard input and printing them out to standard output..
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class twoD_Array {

	public static void main(String[] args) {
		double[][] marray = Utility.arrayElement();

		for (int i = 0; i < marray.length; i++) {
			for (int j = 0; j < marray[i].length; j++) {
				System.out.print(marray[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
