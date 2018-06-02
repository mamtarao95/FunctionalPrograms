/*******************************************************************************
 *  Purpose: This method converts decimal number to its binary representation with necessary padding
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class DecimalToBinary {
	
		public static void main(String[] args) {
			System.out.println("Enter the decimal number:");
			StringBuilder binary=Utility.toBinary(Utility.userInputInteger());
			System.out.println("The binary representation of above number is: "+binary);

}
}