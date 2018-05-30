package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class Calender {

	public static void main(String[] args) {
		 int month=Integer.parseInt(args[0]);
         int year=Integer.parseInt(args[1]);
		Utility.printCalender(month,year);
	}

}
