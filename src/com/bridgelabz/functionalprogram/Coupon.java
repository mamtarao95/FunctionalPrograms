package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;
public class Coupon

{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of distinct coupons you want: ");
		int num=sc.nextInt();
		System.out.println("Enter "+num+" distinct coupons: ");
		int[] ar= new int[num];
		
		for(int i=0;i<num;i++)
		{
			ar[i]=sc.nextInt();
			
		
		}
	   Utility utility=new Utility();
	   int res=utility.randomGen(ar);
      System.out.println("the number of random number needed to have all distinct coupons are :" +res);
	  sc.close();
	}
	}
