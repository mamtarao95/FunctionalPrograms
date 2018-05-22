package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class InsertionSortReader {
	
	public static void main(String[] args) {
		System.out.println("Enter the number of strings you want to enter");
		String[] ar=Utility.insertSortStr(Utility.userInputInteger());
		System.out.println("The sorted array is: ");
		for(int i=0 ;i<ar.length;i++) {
			System.out.print(ar[i]+ ", ");
		}
		
	}

}
