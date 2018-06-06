package com.bridgelabz.objectorientedprgms;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookUser {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ClassCastException, ClassNotFoundException, SecurityException, InterruptedException, ParseException {
		AddressBookController addressBookController=new AddressBookController();
		
		System.out.println("Enter your choice");
		System.out.println("(1)- ADD A PERSON TO ADDRESSBOOK");
		System.out.println("(2)- DELETE A PERSON FROM ADDRESSBOOK");
		System.out.println("(3)- EDIT A PERSON IN ADDRESSBOOK");
		System.out.println("(4)- SORT BY NAME IN ADDRESSBOOK");
		System.out.println("(5)- SORT BY ZIP IN ADDRESSBOOK");
		System.out.println("(6)- PRINT ADDRESSBOOK");
		System.out.println("(7)- CREATE A NEW ADDRESSBOOK");
		
		
		int choice=Utility.userInputInteger();
		switch(choice) {
		
		case 1:
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
		
		/*System.out.println("Enter the addressBook name in which yo want to add");
		String addressBookName=Utility.userInputString();*/
		
		addressBookController.doAdd(firstName, lastName, address, city, state, zip, phone);
		break;
		
		
		case 2:
			System.out.println("The address book details are shown below: ");
			addressBookController.doOpen();
			System.out.println("Enter the index position of the person you want to delete ");
			int index=Utility.userInputInteger();
			addressBookController.doDelete(index);
			System.out.println("The modified address book is shown below: ");
			addressBookController.doOpen();
			break;
			
		case 3: 
			System.out.println("The address book details are shown below: ");
			addressBookController.doOpen();
			System.out.println("Enter the index position of the person you want to edit ");
			int indexEdit=Utility.userInputInteger();
			addressBookController.doEdit(indexEdit);
			
		case 7:
			System.out.println("Creating a new address book");
			addressBookController.doNew();
			break;
			
		}
		
		
		
		
	}

}
