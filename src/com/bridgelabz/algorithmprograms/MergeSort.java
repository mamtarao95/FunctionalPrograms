/*******************************************************************************
 *  Purpose: This method performs merge sorting on the given elements
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class MergeSort {
	
	public static void main(String[] args) {
		System.out.println("Enter the number of elements in the array: ");
		int num=Utility.userInputInteger();
		System.out.println("Enter the elements in the array: ");
		String[] array=new String[num];
		for(int i=0 ;i<num;i++) {
			array[i]=Utility.userInputString();
		}
		System.out.println("Given Array");
       Utility.printArray(array);
       
       Utility.mergeSort(array, 0, array.length-1);
       System.out.println("\nSorted array");
       Utility.printArray(array);
	    }
}	
	 
  
         
  
         
         
  
         
    
 
       


