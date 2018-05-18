package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;

public class PrimeFactors 
{
	public static void main(String[] args)
	{
		Utility utility = new Utility();
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	utility.findPrime(num);
	sc.close();
	}
}
