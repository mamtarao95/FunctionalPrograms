package com.bridgelabz.algorithmprograms;
import com.bridgelabz.util.Utility;

public class GregorianCal {

	public static void main(String[] args) {
		int day= Integer.parseInt(args[0]);
		int month= Integer.parseInt(args[1]);
		int year= Integer.parseInt(args[2]);
		int d1=Utility.dayOfWeek(day,month,year);
		String res = "";

		switch (d1) {
		case 0:
			res = res + "Sunday";
			break;
		case 1:
			res = res + "Monday";
			break;
		case 2:
			res = res + "Tuesday";
			break;
		case 3:
			res = res + "Wednesday";
			break;
		case 4:
			res = res + "Thursday";
			break;
		case 5:
			res = res + "Friday";
			break;
		case 6:
			res = res + "Saturday";
			break;
		default:
			res = res + "error";
			break;
		}
		System.out.println(res);
	}
}
