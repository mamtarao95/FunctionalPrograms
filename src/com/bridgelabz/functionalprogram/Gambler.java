package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;

public class Gambler 
{
	public static void main(String[] args)
	{
		Utility utility = new Utility();
		Scanner sc=new Scanner(System.in);
	System.out.println("enter the stake amount(in Rs): ");
	double stake=sc.nextDouble();
	System.out.println("enter the goal amount(in Rs): ");
	double goal=sc.nextDouble();
	System.out.println("enter the no. of plays: ");
	int plays=sc.nextInt();
	utility.gambling(stake,goal,plays);
     sc.close();

	}

}
