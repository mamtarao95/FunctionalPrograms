package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class DecimalToBinary {
	
		public static void main(String[] args) {
			System.out.println("Enter the decimal number:");
			StringBuilder binary=Utility.toBinary(Utility.userInputInteger());
			System.out.println("The binary representation of above number is: "+binary);

}
}