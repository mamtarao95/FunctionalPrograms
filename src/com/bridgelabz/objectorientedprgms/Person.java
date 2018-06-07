package com.bridgelabz.objectorientedprgms;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Serializable {
	
private String firstName;
private String lastName;
private String address;
private String city;
private String state;
private String zip;
private String phone;
    
/** Comparator for comparing two persons by alphabetical order of name
 */
public static class CompareByName implements Comparator<Object>
{
	/** Compare two objects (which must both be Persons) by last name,
	 *	with ties broken by first name
	 *
	 *	@param person1 the first object
	 *	@param person2 the second object
	 *	@return a negative number if person1 belongs before person2 in
	 *			alphabetical order of name; 0 if they are equal; a
	 *			positive number if person1 belongs after person2
	 *
	 *	@exception ClassCastException if either parameter is not a
	 *			   Person object
	 */
	public int compare(Object person1, Object person2)
	{
		int compareByLast = ((Person) person1).getLastName().compareTo(
			((Person) person2).getLastName());
		if (compareByLast != 0)
			return compareByLast;
		else
			return ((Person) person1).getFirstName().compareTo(
				((Person) person2).getFirstName());
	}
	
	/** Compare two objects (which must both be Persons) by name
	 *
	 *	@param person1 the first object
	 *	@param person2 the second object
	 *	@return true if they have the same name, false if they do not
	 *
	 *	@exception ClassCastException if either parameter is not a
	 *			   Person object
	 */
	public boolean equals(Object person1, Object person2)
	{
		return compare(person1, person2) == 0;
	}
}

/** Comparator for comparing two persons by order of zip code
 */
public static class CompareByZip implements Comparator<Object>
{
	/** Compare two objects (which must both be Persons) by zip
	 *
	 *	@param person1 the first object
	 *	@param person2 the second object
	 *	@return a negative number if person1 belongs before person2 in
	 *			order of zip; 0 if they are equal; a positive number if
	 *		    person1 belongs after person2
	 *
	 *	@exception ClassCastException if either parameter is not a
	 *			   Person object
	 */
	public int compare(Object person1, Object person2)
	{
		int compareByZip = ((Person) person1).getZip().compareTo(
			((Person) person2).getZip());
		if (compareByZip != 0)
			return compareByZip;
		else
			return new CompareByName().compare(person1, person2); 
	}
	
	/** Compare two objects (which must both be Persons) by zip
	 *
	 *	@param person1 the first object
	 *	@param person2 the second object
	 *	@return true if they have the same zip, false if they do not
	 *
	 *	@exception ClassCastException if either parameter is not a
	 *			   Person object
	 */
	public boolean equals(Object person1, Object person2)
	{
		return compare(person1, person2) == 0;
	}
}


public Person() {
	
}
 /**
  * Constructor to initialize the person's details while adding person to address book
  * 
 * @param firstName  FirstName of the person
 * @param lastName   LastName of the person
 * @param address    Address of the person
 * @param city       City of the person
 * @param state      State of the person
 * @param zip 		 ZipCode of the person
 * @param phone 	 PhoneNumber of the person
 */
public Person(String firstName,String lastName,String address,String city,String state,String zip,String phone){
	 this.firstName=firstName;
	 this.lastName=lastName;
	 this.address=address;
	 this.city=city;
	 this.state=state;
	 this.zip=zip;
	 this.phone=phone;
	 
	  }
 


public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setAddress(String address) {
	this.address = address;
}
public void setCity(String city) {
	this.city = city;
}
public void setState(String state) {
	this.state = state;
}
public void setZip(String zip) {
	this.zip = zip;
}
public void setPhone(String phone) {
	this.phone = phone;
}
/**
 * @return firstName of the person
 */
public String getFirstName() {
	 return firstName;
	 }
 
 /**
 * @return LastName of the person
 */
public String getLastName() {
	 return lastName;
	 }

/**
* @return Address of the person
*/
 public String getAddress() {
	 return address;
	 }
 
 /**
 * @return City of the person
 */
 public String getCity() {
	 return city;
	 }
 

 /**
 * @return state of the person
 */
public String getState() {
	 return state;
	 }

 /**
 * @return  ZipCode of the person
 */
 public String getZip() {
	 return zip;
	 }
 
 /**
 * @return PhoneNumber of the person
 */
 public String getPhone() {
	 return phone;
	 }
 
 
 /**
  * Method to update the details of the person
 * @param address  Address of the person
 * @param city     City of the person
 * @param state    State of the person
 * @param zip      ZipCode of the person
 * @param phone    Phone of the person
 */
public void updatePerson(String address,String city,String state,String zip,String phone) {
	
	 this.address=address;
	 this.city=city;
	 this.state=state;
	 this.zip=zip;
	 this.phone=phone;
 }



	
	
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
