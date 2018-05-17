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

public class ReplaceString
{
	/*
	 * The main function is written to test PrimeChecker class
	 */
	public static void main(String[] args)
	{
		/*
		 * mtemplate stores the given String
		 */
		String mtemplate="Hello <<username>> , How are you?";
		Utility utility=new Utility();
		
		/*
		 * mresult stores the returned modified string
		 */
		String mresult=utility.replaceUserName(mtemplate);
		System.out.println(mresult);
		
		}

}
