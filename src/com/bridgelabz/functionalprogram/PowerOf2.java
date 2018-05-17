package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;
import java.util.Scanner;

public class PowerOf2
{
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the power value N (2^N): ");
	int power=sc.nextInt();

	if(power<31)
	{
	Utility utility =new Utility();
	utility.printPower(power);
	}
	else
	{
	System.out.println("Enter value less than 32!!");
	}
	sc.close();
	}
	

}
