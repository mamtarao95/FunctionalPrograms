/*******************************************************************************
 *  Purpose: This method reads from the file and store in linked list in ordered manner
 *   		 where it performs operation as per user's requirement
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.datastructureprograms;

import java.io.File;
import java.io.FileNotFoundException;
import com.bridgelabz.util.Utility;

public class OrderedList {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/administrator/Documents/test2");
		Utility.orderedList(file);
	}

}
