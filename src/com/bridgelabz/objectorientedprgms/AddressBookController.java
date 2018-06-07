package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookController {
	static String template = "/home/administrator/mamta-workspace/Basicjavaprograms/";
	AddressBook addressBook = new AddressBook();
	LinkedList<String> addressBookList = new LinkedList<String>();
	ArrayList<Object> arrayList = new ArrayList<Object>();
	ArrayList<String> newList = new ArrayList<String>();

	/**
	 * Method to ADD a person to the particular address book
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void doAdd(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException,
			ParseException, SecurityException, InterruptedException {
		File fileAdd = findAddressBook(addressBookName);
		String[] inputs = AddressUtility.askForInputs();
		addressBook.addPerson(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5], inputs[6], fileAdd);
	}

	/**
	 * Method to UPDATE a person's details in the particular address book
	 * 
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void doEdit() throws ClassCastException, ClassNotFoundException, SecurityException, IOException,
			InterruptedException, ParseException {
		System.out.println("Enter the address book in which you want to perform editing ");
		String addressBookEdit = Utility.userInputString();
		doOpen(addressBookEdit);

		File file = findAddressBook(addressBookEdit);
		System.out.println("Enter the index position of the person you want to edit ");
		int index = Utility.userInputInteger();
		String[] inputs = AddressUtility.askForInputsUpdate();
		addressBook.updatePerson(index, inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], file);

	}

	
	
	
	
	
	/**
	 * Method to delete the person from the file
	 * 
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void doDelete() throws ClassCastException, ClassNotFoundException, SecurityException, IOException,
			InterruptedException, ParseException {
		System.out.println("Enter the addressbook from which you want to delete ");
		String addressBookNameOpen = Utility.userInputString();
		doOpen(addressBookNameOpen);

		File file = findAddressBook(addressBookNameOpen);
		System.out.println("Enter the index position of the person you want to delete ");
		int index = Utility.userInputInteger();
		addressBook.removePerson(index, file);
		System.out.println("Successfully deleted!!! ");
		doOpen(addressBookNameOpen);

	}

	
	public void doSortByName() throws FileNotFoundException, IOException, ParseException, ClassCastException,
			ClassNotFoundException, SecurityException, InterruptedException {
		System.out.println("Enter the address book from which you want to sort ");
		String addressBookName = Utility.userInputString();
		doOpen(addressBookName);
		File file = new File(template + addressBookName + ".json");
		addressBook.sortByName(file);
	}

	public void doSortByZip() throws ClassCastException, ClassNotFoundException, SecurityException, IOException, InterruptedException, ParseException {
		System.out.println("Enter the address book from which you want to sort ");
		String addressBookName = Utility.userInputString();
		doOpen(addressBookName);
		File file = new File(template + addressBookName + ".json");
		addressBook.sortByZip(file);
	}

	public void doPrint() {
		addressBook.printAll();
	}

	public void doNew() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser
				.parse(new FileReader("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json"));
		JSONArray array = (JSONArray) obj;

		for (int i = 0; i < array.size(); i++) {
			newList.add((String) array.get(i));
		}

		String template = "/home/administrator/mamta-workspace/Basicjavaprograms/";
		System.out.println("Enter the name of new address book ");
		String addressBookName = Utility.userInputString();
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(template + addressBookName + ".json");

		newList.add(file.toString());
		mapper.writeValue(file, addressBook.personList);

		File pathAddress = new File("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json");
		mapper.writeValue((pathAddress), newList);

	}

	public void doOpen(String addressBookNameOpen)
			throws java.io.IOException, java.lang.ClassCastException, java.lang.ClassNotFoundException,
			java.lang.InterruptedException, java.lang.SecurityException, ParseException {

		File fileOpen = findAddressBook(addressBookNameOpen);
		System.out.println("The address book details are shown below: ");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(fileOpen));
		JSONArray array1 = (JSONArray) obj;
		System.out.println(array1.toString());
	}

	/**
	 * Method to get the full name of the person
	 * 
	 * @param index
	 * @param addressBookName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws ClassCastException
	 */
	public void getFullNameOfPerson() throws FileNotFoundException, IOException, ParseException, ClassCastException,
			ClassNotFoundException, SecurityException, InterruptedException {

		displayAddressBookList();
		System.out.println("Select the address book ");
		String addressBookName = Utility.userInputString();
		doOpen(addressBookName);
		File file = findAddressBook(addressBookName);
		System.out.println("Enter the index of the person");
		int index = Utility.userInputInteger();
		System.out.println(addressBook.getFullNameOfPerson(index, file));
	}

	/**
	 * Method to find address book from the address book list
	 * 
	 * @param addressBookName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public File findAddressBook(String addressBookName) throws FileNotFoundException, IOException, ParseException {

		// parse to select multiple address books
		JSONParser parser = new JSONParser();
		Object obj = parser
				.parse(new FileReader("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json"));
		JSONArray array = (JSONArray) obj;

		for (int i = 0; i < array.size(); i++) {
			newList.add((String) array.get(i));
		}

		int index = newList.indexOf(template + addressBookName + ".json");
		File file = new File(newList.get(index));
		return file;

	}

	/**
	 * Method to display address book
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void displayAddressBookList() throws FileNotFoundException, IOException, ParseException {
		File fileDisplay = new File("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json");
		System.out.println(addressBook.parseJSON(fileDisplay).toString());
	}

	/**
	 * Method to delete the address book
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void deleteBook()
			throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException {
		displayAddressBookList();
		System.out.println("Enter the name of addressBook list which you want to delete");
		String addressBookName = Utility.userInputString();
		JSONParser parser = new JSONParser();
		Object obj = parser
				.parse(new FileReader("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json"));
		JSONArray array = (JSONArray) obj;

		for (int i = 0; i < array.size(); i++) {
			newList.add((String) array.get(i));
		}
		int index = newList.indexOf(template + addressBookName + ".json");
		newList.remove(index);
		System.out.println("Are you sure you want to delete??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			addressBook.doSave(new File("/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json"),
					newList);
		}

	}

}
