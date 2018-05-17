package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;
import java.util.Scanner;

public class Distance 
{
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the value of X: ");
	double x=sc.nextDouble();
	System.out.println("Enter the value of Y: ");
	double y=sc.nextDouble();
	
	Utility utility=new Utility();
	double distOrigin=utility.calcEuclid(x,y);
	System.out.println("The euclid distance from origin(0,0) to point("+x+","+y+") is: ");
	System.out.println(distOrigin);
	
	sc.close();
	}

}
