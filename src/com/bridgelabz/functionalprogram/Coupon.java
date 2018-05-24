/******************************************************************************
 *  Purpose: ­> Given N distinct Coupon Numbers, how many random numbers do you
	need to generate distinct coupon number? This program simulates this random
	process.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class Coupon {
	public static void main(String[] args) {
		System.out.println("Enter the number of distinct coupons you want: ");
		int num=Utility.userInputInteger();
		int[] ar = new int[num];
		int totalRandomNum = Utility.randomGen(ar,num);
		System.out.println("The number of random number needed to have all distinct coupons are :" + totalRandomNum);
		}
}
