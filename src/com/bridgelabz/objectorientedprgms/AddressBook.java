/******************************************************************************
 *  Purpose:This program is for AddressBook,manages list of person in the address book
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBook {
	ArrayList<Person> personList=new ArrayList<Person>();
	Person person = new Person();
	ObjectMapper mapper = new ObjectMapper();

	
	/**
	 * Method to add person's details( to the address book
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address       
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,String phone, File fileAdd) throws JsonGenerationException, JsonMappingException, IOException, ParseException,SecurityException, InterruptedException {
		personList = AddressUtility.parseJSONArray(fileAdd, Person.class);
		Person person = new Person(firstName, lastName, address, city, state, zip, phone);
		personList.add(person);

		System.out.println("Do you want to save??(Y/N)");
		if (Utility.userInputString().equals("Y")) {
			doSave(fileAdd,personList);
			System.out.println("Added Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
	}

	
	
	public String getFullNameOfPerson(int index,File file) throws FileNotFoundException, IOException, ParseException {
		personList= AddressUtility.parseJSONArray(file, Person.class);
		String firstName = personList.get(index).getFirstName();
		String lastName =  personList.get(index).getLastName();
		return  (firstName+lastName) ;
	}

	public int getNumberOfPersons(File file) throws FileNotFoundException, IOException, ParseException {
		personList=AddressUtility.parseJSONArray(file,Person.class);
		return personList.size();
		
	}

	public String[] getOtherPersonInformation(int index) {
		Person person = (Person) personList.get(index);
		String[] otherInformation = { person.getAddress(), person.getCity(), person.getZip(), person.getState(),
				person.getPhone() };
		return otherInformation;
	}

	/**
	 * Method to update person's details(apart from his/her name)
	 * 
	 * @param index
	 *            Position of person in the address book
	 * @param address
	 *            Address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void updatePerson(int index, String address, String city, String state, String zip, String phone, File file)
		throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {
		personList = AddressUtility.parseJSONArray(file, Person.class);

		String firstName = personList.get(index).getFirstName();
		String lastName =  personList.get(index).getLastName();
		personList.remove(personList.get(index));
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		person.setCity(city);
		person.setPhone(phone);
		person.setState(state);
		person.setZip(zip);

		personList.add(index,person);

		System.out.println("Do you want to save??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			doSave(file, personList);
			System.out.println("Updated Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
}

	/**
	 * Method to DELETE a person from the address book
	 * 
	 * @param index
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void removePerson(int index, File file)
			throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {
		personList = AddressUtility.parseJSONArray(file,Person.class);
		personList.remove(personList.get(index));
		mapper.writeValue((file),personList);

		System.out.println("Do you want to save??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			doSave(file, personList);
			System.out.println("Successfully deleted!!! ");
		}
		else {
		System.out.println("Changes not saved !!! ThankYou ");
		}

	}

	
	
	/**
	 * **Method to SORT the persons on your list based on LASTNAME
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void sortByName(File file) throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {

		personList = AddressUtility.parseJSONArray(file,Person.class);
		for(int i=0 ; i<personList.size()-1;i++) {
			for(int j=i+1; j<personList.size();j++) {
				String person1=personList.get(i).getLastName();
				String person2=personList.get(j).getLastName();
				if (person1.compareTo(person2)>0) {
					Person temp =personList.get(i);
					personList.set(i,personList.get(j));
					personList.set(j,temp);
					}
				}
			}		
		doSave(file,personList);
		System.out.println("Sorted successfully..!!");
		
	
		}

	
	/**
	 * **Method to SORT the persons on your list based on LASTNAME
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void sortByZip(File file) throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {

		personList = AddressUtility.parseJSONArray(file,Person.class);
		for(int i=0 ; i<personList.size()-1;i++) {
			for(int j=i+1; j<personList.size();j++) {
				String person1=personList.get(i).getZip();
				String person2=personList.get(j).getZip();
				if (person1.compareTo(person2)>0) {
					Person temp =personList.get(i);
					personList.set(i,personList.get(j));
					personList.set(j,temp);
					}
				}
			}		
		doSave(file,personList);
		System.out.println("Sorted successfully..!!");
		
	
		}
	/**
	 * Method to save the last changes made to the address book
	 * 
	 * @param file
	 * @param arrayList
	 * @throws java.io.IOException
	 * @throws java.lang.InterruptedException
	 * @throws java.lang.SecurityException
	 */
	public void doSave(File file, ArrayList personList)
			throws java.io.IOException, java.lang.InterruptedException, java.lang.SecurityException {
		mapper.writeValue((file), personList);
	
	}

}
