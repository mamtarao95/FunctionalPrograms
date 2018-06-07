package com.bridgelabz.objectorientedprgms;

import com.bridgelabz.util.Utility;

public class AddressUtility {
	
	public static String[] askForInputs() {
		System.out.println("Enter the first name of the person");
		String firstName=Utility.userInputString();
		
		System.out.println("Enter the last name of the person");
		String lastName=Utility.userInputString();
		
		System.out.println("Enter the address of the person");
		String address=Utility.userInputString();
		
		System.out.println("Enter the city of the person");
		String city=Utility.userInputString();
		
		System.out.println("Enter the state of the person");
		String state=Utility.userInputString();
		
		System.out.println("Enter the zipCode of the area");
		String zip=Utility.userInputString();
		
		System.out.println("Enter the phone number of the person");
		String phone=Utility.userInputString();
		
		String[] string= {firstName,lastName,address,city,state,zip,phone};
		return string;
		
	}
	
	public static String[] askForInputsUpdate() {
	
		System.out.println("Enter the address of the person");
		String address=Utility.userInputString();
		
		System.out.println("Enter the city of the person");
		String city=Utility.userInputString();
		
		System.out.println("Enter the state of the person");
		String state=Utility.userInputString();
		
		System.out.println("Enter the zipCode of the area");
		String zip=Utility.userInputString();
		
		System.out.println("Enter the phone number of the person");
		String phone=Utility.userInputString();
		
		String[] string= {address,city,state,zip,phone};
		return string;
		
	}
	
	
	

}
