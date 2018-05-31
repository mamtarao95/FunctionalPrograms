package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class SearchAndSort {
	public static void main(String[] args) {
		
		System.out.println("Select which type of array you want to sort :");
		System.out.println("1: Integer");
		System.out.println("2: String");
		int choice=Utility.userInputInteger();
		
		switch(choice) {
		
		case 1: 
		System.out.println("Enter the size of integer array: ");
		int sizeInt=Utility.userInputInteger();
		Integer[] array=new Integer[sizeInt];
		System.out.println("Enter the elements of the integer array");
		for(int i=0 ; i<array.length ; i++){
			array[i]=Utility.userInputInteger();
		}
		Utility.compareElapsedTime(array);
		break;
		
		case 2:
		System.out.println("Enter the size of string array: ");
		int sizeString=Utility.userInputInteger();
		String[] array1=new String[sizeString];
		System.out.println("Enter the elements of the String array");
		for(int i=0 ; i<array1.length ; i++){
			array1[i]=Utility.userInputString();
		}
		Utility.compareElapsedTime(array1);
		break;
		
		default:System.out.println("Enter valid data"); 

		}
	}

}
