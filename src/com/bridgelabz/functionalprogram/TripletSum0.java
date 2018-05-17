package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;
import java.util.Scanner;

public class TripletSum0 
{
	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of integers you want in the array: ");
	int num=sc.nextInt();
	int[] ar=new int[num];
	System.out.println("Enter "+num+ " integers: " );
	for(int i=0;i<num;i++)
	{
		ar[i]=sc.nextInt();
	}
	
	Utility utility=new Utility();
	utility.sumTriplet(ar);
	sc.close();
	}
	
}
