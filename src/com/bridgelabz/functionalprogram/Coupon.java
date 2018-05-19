package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Coupon
{
	public static void main(String[] args)
	{
		System.out.println("Enter the number of distinct coupons you want: ");
		int totalRandomNum=Utility.randomGen(Utility.userInputInteger());
		System.out.println("the number of random number needed to have all distinct coupons are :"+totalRandomNum);
	  
	}
	}
