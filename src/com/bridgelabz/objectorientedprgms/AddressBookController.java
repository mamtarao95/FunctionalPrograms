package com.bridgelabz.objectorientedprgms;

import java.nio.file.FileSystem;

public class AddressBookController {
	AddressBook addressBook=new AddressBook();
	
	public AddressBookController(FileSystem fileSystem) {
		
	}
	
	public void doAdd(String firstName,String lastName,String address,String city,String state,String zip,String phone) {
		addressBook.addPerson( firstName,lastName, address, city, state, zip, phone);
		}
	
	public void doEdit(int index) {
		
	}

}
