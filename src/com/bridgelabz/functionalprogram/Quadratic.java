package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;

public class Quadratic
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter value of a:");
		double a=sc.nextDouble();
		System.out.println("Enter value of b:");
		double b=sc.nextDouble();
		System.out.println("Enter value of c:");
		double c=sc.nextDouble();
		Utility utility=new Utility();
		double[] ar=utility.findRoots(a,b,c);
		
		System.out.println("First root of the given equation is :");
		System.out.println(ar[0]);

		System.out.println("Second root of the given equation is :");
		System.out.println(ar[1]);
		
		sc.close();
		
	}

	

}
