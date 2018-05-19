/******************************************************************************
 *  Purpose: Replace a string with user input in the given template.
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/

package com.bridgelabz.functionalprogram;

import com.bridgelabz.util.Utility;

public class ReplaceString {
	public static void main(String[] args) {
		String mtemplate = "Hello <<username>> , How are you?";
		System.out.println(Utility.replaceUserName(mtemplate));
	}

}
