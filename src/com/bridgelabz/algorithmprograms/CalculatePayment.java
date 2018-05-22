package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class CalculatePayment {
	
	public static void main(String[] args) {
		double principal=Double.parseDouble(args[0]);
		double year=Double.parseDouble(args[1]);
		double rate=Double.parseDouble(args[2]);
		double res=Utility.monthlyPayment(principal,year,rate);
		System.out.println("The monthly payment amount tobe made is: "+res);
	}

}
