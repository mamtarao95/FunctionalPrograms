package com.bridgelabz.objectorientedprgms;

import java.util.LinkedList;

public class AddressBook {
LinkedList<Person> linkedList = new LinkedList<Person>();
Person.CompareByName compareByName=new Person.CompareByName();
Person.CompareByZip compareByZip=new Person.CompareByZip();
Person person=new Person();
public AddressBook() {
	
}

public void addPerson(String firstName,String lastName,String address,String city,String state,String zip,String phone){
	Person person= new Person(firstName,lastName,address,city,state,zip,phone);
	linkedList.add(person);
	}

public String getFullNameOfPerson(int index) {
	return linkedList.get(index).getFirstName()+linkedList.get(index).getLastName();
	}

public int getNumberOfPersons() {
	return linkedList.size();
}

public String getOtherPersonInformation(int index) {
	Person person=linkedList.get(index);
	String otherInformation=person.getAddress()+"  "+person.getCity()+"  "+person.getZip()+"  "+person.getState();
	return otherInformation;
}

public void updatePerson(int index,String address,String city,String state,String zip,String phone) {
	
}

public void removePerson(int index) {
	linkedList.remove(index);
}


public void sortByName() {
	for(int index=0 ; index<linkedList.size() ; index++) {
		compareByName.compare(linkedList.get(index), linkedList.get(index+1));
	}
	
}

public void sortByZip() {
		for(int index=0 ; index<linkedList.size() ; index++) {
			compareByZip.compare(linkedList.get(index),linkedList.get(index+1));
		}
		
	}
		
public void printAll() {
linkedList.toString();
}

public String toString() {
    
   return "FirstName: "+person.getFirstName()+"; LastName: "+person.getLastName()+"; Address: "+ person.getAddress()+"; City: "+person.getCity()+"; ZipCode: "+person.getZip()+"; State: "+person.getState()+"; PhoneNumber: "+person.getPhone();  
}











}




	

