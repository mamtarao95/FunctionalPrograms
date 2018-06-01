/*******************************************************************************
 *  Purpose: This method performs insertion sort on string values
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/

package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class BubbleSortInteger {
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		int size=Utility.userInputInteger();
		long starttime=System.nanoTime();
		int[] ar=Utility.bubbleSortInt(size);
		long elapsedtime=System.nanoTime()-starttime;
		System.out.println("The sorted array is: ");
		for(int i=0 ;i<size;i++) {
			System.out.print(ar[i]+ ", ");
		}
		System.out.println();
		System.out.println("The elapsed time for the searching operation is: "+elapsedtime+"ns");
		
	}
	

}
