package com.bridgelabz.functionalprogram;
import java.util.Scanner;
import com.bridgelabz.util.Utility;

public class PermuteString
{
public static void main(String[] args)
{
	
	Scanner sc = new Scanner(System.in);
	Utility utility=new Utility();
	
	String str=sc.next();
	char[] ch=str.toCharArray();
	
	utility.permutation(ch,0);
	sc.close();
	
	
	
	
}
}