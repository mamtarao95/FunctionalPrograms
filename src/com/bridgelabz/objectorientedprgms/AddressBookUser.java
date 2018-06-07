package com.bridgelabz.objectorientedprgms;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;
import com.bridgelabz.util.Utility;

public class AddressBookUser {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ClassCastException, ClassNotFoundException, SecurityException, InterruptedException, ParseException {
		AddressBookController addressBookController=new AddressBookController();
		System.out.println("WELCOME TO ADDRESS BOOK APPLICATION...!!! ");
		System.out.println("Enter your choice");
		
		System.out.println("(1)- CREATE A NEW ADDRESSBOOK");
		System.out.println("(2)- VIEW A PARTICULAR ADDRESSBOOK");
		System.out.println("(3)- OPEN EXISTING ADDRESSBOOK");
		System.out.println("(4)- VIEW ADDRESSBOOK LIST");
		System.out.println("(5)- DELETE ADDRESSBOOK");
		
		int choice=Utility.userInputInteger();
		switch(choice) {
		
		case 1:
		System.out.println("Creating a new address book..!!!");
		System.out.println("Enter the name of new address book ");
		String addressBookName1 = Utility.userInputString();
		addressBookController.doNew(addressBookName1);
		System.out.println("Now you may add persons on your new address book..!!!");
		System.out.println("(1)- ADD A PERSON TO ADDRESSBOOK");
		System.out.println("(2)- QUIT ADDRESSBOOK");
			int choice1=Utility.userInputInteger();
			switch(choice1) {
			case 1:
			addressBookController.doAdd(addressBookName1);
			break;
			
			default: System.out.println("Exiting address book..!! ThankYou");
			}
		
		break;
	
		case 2:
			addressBookController.displayAddressBookList();
			System.out.println("Enter the address book you want to view ");
			addressBookController.doOpen(Utility.userInputString());
			break;
		
		case 3:
			System.out.println("Enter the name of address book you want to open ");
			String addressBookName=Utility.userInputString();
			addressBookController.doOpen(addressBookName);
			System.out.println("You may perform following operations on existing address book ");
			System.out.println("(1)- ADD A PERSON TO ADDRESSBOOK");
			System.out.println("(2)- DELETE A PERSON FROM ADDRESSBOOK");
			System.out.println("(3)- EDIT A PERSON IN ADDRESSBOOK");
			System.out.println("(4)- SORT BY NAME IN ADDRESSBOOK");
			System.out.println("(5)- SORT BY ZIP IN ADDRESSBOOK");
			System.out.println("(6)- GET PERSON'S FULL NAME");
			System.out.println("(7)- QUIT ADDRESSBOOK");
			
				int choice2=Utility.userInputInteger();
				switch(choice2) {
			
				case 1:
					addressBookController.doAdd(addressBookName);
					break;
			
				case 2:
					addressBookController.doDelete(addressBookName);
					break;
				
				case 3: 
					addressBookController.doEdit(addressBookName);
					break;
			
				case 4:
					addressBookController.doSortByName(addressBookName);	
					break;
			
				case 5:
					addressBookController.doSortByZip(addressBookName);
					break;
				
				case 6:
					addressBookController.getFullNameOfPerson();
					break;
			
				default: System.out.println("Exiting address book..!! ThankYou");
			break;
				}
				break;
				
		case 4:
			addressBookController.displayAddressBookList();
			break;
			
			
		case 5:
			addressBookController.deleteBook();
			break;
		}
		}
	}

		
		
	

