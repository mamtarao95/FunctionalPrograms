package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class FindSquareRoot {

		public static void main(String[] args) {
			System.out.println("Enter a non-negative number");
			double res=Utility.sqrt(Utility.userInputDouble(),Utility.userInputDouble());
			if(res==-1) {
				System.out.println("No roots");
			}
			System.out.println(res);
		   }
}
