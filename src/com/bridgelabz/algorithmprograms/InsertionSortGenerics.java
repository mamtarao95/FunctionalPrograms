/*******************************************************************************
 *  Purpose: This method performs generic insertion sort
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class InsertionSortGenerics {

		public static void main(String[] args) {
			
			//Invoke generic method by integer as input
			System.out.println("Enter the size of integer array");
			int size=Utility.userInputInteger();
			Integer[] ar=new Integer[size];
			System.out.println("Enter the elements in the array");
			for(int i=0 ; i<ar.length ; i++){
				ar[i]=Utility.userInputInteger();
			}
			 ar=Utility.insertSortGen(ar);
			System.out.println("The sorted array is: ");
			for(int i=0 ;i<size;i++) {
				System.out.print(ar[i]+ ", ");
			}
			
			
			
			
			//Invoke generic method by string as input
			System.out.println("Enter the size of string array");
			int size1=Utility.userInputInteger();
			String[] ar1=new String[size1];
			System.out.println("Enter the elements in the array");
			for(int i=0 ; i<ar1.length ; i++){
				ar1[i]=Utility.userInputString();
			}
			 ar1=Utility.insertSortGen(ar1);
			System.out.println("The sorted array is: ");
			for(int i=0 ;i<size1;i++) {
				System.out.print(ar1[i]+ ", ");
			}
			
			
		}
}
