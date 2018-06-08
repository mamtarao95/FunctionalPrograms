package com.bridgelabz.objectorientedprgms;

import java.io.Serializable;

public class Person implements Serializable {
	
private String firstName;
private String lastName;
private String address;
private String city;
private String state;
private String zip;
private String phone;
    

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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
