package com.bridgelabz.functionalprogram;
import com.bridgelabz.util.Utility;

public class twoD_Array 
{

  public static void main(String[] args)
	{
	Utility utility=new Utility();
	
	/*
	 * two dimensional double type array stores the returned array
	 */
    double[][] marray=utility.arrayElement();
	
    /*/
     * loop to display the 2D array elements in matrix format in the output
     */
    for(int i=0 ; i<marray.length ; i++)
	{
		for(int j=0 ; j<marray[i].length; j++)
		{
			System.out.print(marray[i][j]+"  ");
		}
		System.out.println();
	}

}
}

