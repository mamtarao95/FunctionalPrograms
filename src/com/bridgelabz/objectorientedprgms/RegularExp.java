package com.bridgelabz.objectorientedprgms;


import com.bridgelabz.util.Utility;

public class RegularExp {
	public static void main(String[] args) {
		String template="Hello <<name>>, We have your full name as <<full name>> in our system. Your contact number is 91­-xxxxxxxxxx.Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016";
	System.out.println("Enter the your user name!!");
	String userName=Utility.userInputString();
	System.out.println("Enter the your full name!!");
	String fullName=Utility.userInputString();
	System.out.println("Enter the your phone number!!");
	String number=Utility.userInputString();
	
	Utility.replaceRegExp(userName,fullName,number,template);
	
	}

}
