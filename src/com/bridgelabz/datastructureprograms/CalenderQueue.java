/*******************************************************************************
 *  Purpose: This method displays calender using queue
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class CalenderQueue {
	public static void main(String[] args) {
		 int month=Integer.parseInt(args[0]);
         int year=Integer.parseInt(args[1]);
		Utility.calenderQueue(month,year);
	}

}
