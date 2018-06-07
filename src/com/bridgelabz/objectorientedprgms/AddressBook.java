package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBook {
	ArrayList<Object> arrayList = new ArrayList<Object>();
	ArrayList<Person> personList = new ArrayList<Person>();
	Person.CompareByName compareByName = new Person.CompareByName();
	Person.CompareByZip compareByZip = new Person.CompareByZip();
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
		ArrayList<Object> arrayList1 = new ArrayList<Object>();
		arrayList1 = parseJSON(fileAdd);
		Person person = new Person(firstName, lastName, address, city, state, zip, phone);
		arrayList1.add(person);

		System.out.println("Do you want to save??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			doSave(fileAdd, arrayList1);
		}
	}

	
	public String getFullNameOfPerson(int index,File file) throws FileNotFoundException, IOException, ParseException {
		arrayList = parseJSON(file);
		JSONObject jsonObject = (JSONObject)arrayList.get(index);
		String firstName = (String)jsonObject.get("firstName");
		String lastName = (String)jsonObject.get("lastName");
		return  (firstName+lastName) ;
	}

	public int getNumberOfPersons() {
		return personList.size();
	}

	public String[] getOtherPersonInformation(int index) {
		Person person = personList.get(index);
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
		arrayList = parseJSON(file);
		JSONObject jsonObject = (JSONObject) arrayList.get(index);
		String firstName = (String) jsonObject.get("firstName");
		String lastName = (String) jsonObject.get("lastName");
		arrayList.remove(arrayList.get(index));
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		person.setCity(city);
		person.setPhone(phone);
		person.setState(state);
		person.setZip(zip);

		arrayList.add(index, person);

		System.out.println("Do you want to save??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			doSave(file, arrayList);
		}

	}

	/**
	 * Method to delete a person from the address book
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
		arrayList = parseJSON(file);
		arrayList.remove(arrayList.get(index));
		mapper.writeValue((file), arrayList);

		System.out.println("Do you want to save??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			doSave(file, arrayList);
		}

	}

	public void sortByName(File file) throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {

		arrayList = parseJSON(file);
		
		for(int i=0 ; i<arrayList.size()-1;i++) {
			for(int j=i+1; j<arrayList.size();j++) {
				JSONObject jsonObject1 = (JSONObject) arrayList.get(i);
				String lastName1 = (String) jsonObject1.get("lastName");
				JSONObject jsonObject2 = (JSONObject) arrayList.get(j);
				String lastName2 = (String) jsonObject2.get("lastName");
				
				if (lastName1.compareTo(lastName2)>0) {
					JSONObject temp =jsonObject1;
					arrayList.set(i,jsonObject2);
					arrayList.set(j,temp);
		
				}
				
			}
		}
		doSave(file,arrayList);
		System.out.println("Sorted successfully..!!");
		
		}

	public void sortByZip(File file) throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {
		arrayList = parseJSON(file);
		
		for(int i=0 ; i<arrayList.size()-1;i++) {
			for(int j=i+1; j<arrayList.size();j++) {
				JSONObject jsonObject1 = (JSONObject) arrayList.get(i);
				String zip1 = (String) jsonObject1.get("zip");
				JSONObject jsonObject2 = (JSONObject) arrayList.get(j);
				String zip2 = (String) jsonObject2.get("zip");
				
				if (zip1.compareTo(zip2)>0) {
					JSONObject temp =jsonObject1;
					arrayList.set(i,jsonObject2);
					arrayList.set(j,temp);
		
				}
				
			}
		}
		doSave(file,arrayList);
		System.out.println("Sorted successfully..!!");
		

	}

	public void printAll() {
		arrayList.toString();
	}

	public String toString() {

		return "FirstName: " + person.getFirstName() + "; LastName: " + person.getLastName() + "; Address: "
				+ person.getAddress() + "; City: " + person.getCity() + "; ZipCode: " + person.getZip() + "; State: "
				+ person.getState() + "; PhoneNumber: " + person.getPhone();
	}

	/**
	 * Method to parse the JSON file and store into the array list
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public ArrayList<Object> parseJSON(File file) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser1 = new JSONParser();
		Object obj1 = parser1.parse(new FileReader(file));
		JSONArray array1 = (JSONArray) obj1;

		for (int i = 0; i < array1.size(); i++) {
			arrayList.add(array1.get(i));
		}
		return arrayList;
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
	public void doSave(File file, ArrayList arrayList)
			throws java.io.IOException, java.lang.InterruptedException, java.lang.SecurityException {
		mapper.writeValue((file), arrayList);
	
	}

}
