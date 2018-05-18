package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;

public class Harmonic
{
	public static void main(String[] args)
	{
	Utility utility=new Utility();
	Scanner sc=new Scanner(System.in);
	int number=sc.nextInt();
	double res=utility.findHarmonic(number);
	System.out.println("the harmonic number is :" + res);
    sc.close();
	}

}
