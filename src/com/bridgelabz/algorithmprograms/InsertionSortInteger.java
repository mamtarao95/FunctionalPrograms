/******************************************************************************
 *  Purpose: This method performs insertion sort on integer values
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class InsertionSortInteger {
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		int size=Utility.userInputInteger();
		
		int[] array=new int[size];
		System.out.println("Enter the elements in the array");
		
		for(int i=0 ; i<size ; i++){
			array[i]=Utility.userInputInteger();
		}
		
		long starttime=System.nanoTime();
		int[] array1=Utility.insertSortInt(array);
		long elapsedtime=System.nanoTime()-starttime;
		
		System.out.println("The sorted array is: ");
		for(int i=0 ;i<size;i++) {
			System.out.print(array1[i]+ ", ");
		}
		System.out.println();
		System.out.println("The elapsed time for the searching operation is: "+elapsedtime+"ns");
		
	}
	

}
