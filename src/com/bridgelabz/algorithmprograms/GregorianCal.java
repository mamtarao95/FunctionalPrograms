package com.bridgelabz.algorithmprograms;
import com.bridgelabz.util.Utility;

public class GregorianCal {

	public static void main(String[] args) {
		int day= Integer.parseInt(args[0]);
		int month= Integer.parseInt(args[1]);
		int year= Integer.parseInt(args[2]);
		String res=Utility.dayOfWeek(day,month,year);
		System.out.println(res);
	}
}
