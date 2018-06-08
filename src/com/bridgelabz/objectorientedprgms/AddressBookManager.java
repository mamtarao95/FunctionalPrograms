/******************************************************************************
 *  Purpose:Program for the addressBookManager, manages the address book
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
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookManager {

	AddressBook addressBook = new AddressBook();
	ObjectMapper mapper = new ObjectMapper();
	AddressUtility addressUtility= new AddressUtility();
	public ArrayList<Person> personList = new ArrayList<Person>();
	public ArrayList<String> addressBookList = new ArrayList<String>();
	static String template = "/home/administrator/mamta-workspace/Basicjavaprograms/";
	static String bookList="/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json";
	
	
	
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
	public void doAdd(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException,ParseException, SecurityException, InterruptedException {
		File fileAdd = findAddressBook(addressBookName);
		if(fileAdd!=null) {
		String[] inputs = AddressUtility.askForInputs();
		addressBook.addPerson(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5], inputs[6], fileAdd);
	}
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
	public void doEdit(String addressBookEdit) throws ClassCastException, ClassNotFoundException, SecurityException, IOException,InterruptedException, ParseException {
		doOpen(addressBookEdit);

		File file = findAddressBook(addressBookEdit);
	
		System.out.println("Enter the index position of the person you want to edit ");
		int index = Utility.userInputInteger();
		String[] inputs = AddressUtility.askForInputsUpdate();
		addressBook.updatePerson(index, inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], file);
		
	}

	
	
	
	/**
	 * Method to DELETE the person from the file
	 * 
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void doDelete(String addressBookNameOpen) throws ClassCastException, ClassNotFoundException, SecurityException, IOException,InterruptedException, ParseException {
		doOpen(addressBookNameOpen);
		File file = findAddressBook(addressBookNameOpen);
		if(file!=null) {
		System.out.println("Enter the index position of the person you want to delete ");
		int index = Utility.userInputInteger();
		addressBook.removePerson(index, file);
		doOpen(addressBookNameOpen);
		}
	}

	
	
	
	/**Method to SORT the persons on your list based on LASTNAME
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws InterruptedException
	 */
	public void doSortByName(String addressBookName ) throws FileNotFoundException, IOException, ParseException, ClassCastException,ClassNotFoundException, SecurityException, InterruptedException {
		doOpen(addressBookName);
		File file = new File(template + addressBookName + ".json");
		addressBook.sortByName(file);
		System.out.println("The sorted list is :");
		doOpen(addressBookName);
	}

	
	
	
	/**Method to SORT the persons on your list based on ZIP
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void doSortByZip(String addressBookName) throws ClassCastException, ClassNotFoundException, SecurityException, IOException, InterruptedException, ParseException {
		doOpen(addressBookName);
		File file = new File(template + addressBookName + ".json");
		addressBook.sortByZip(file);
		System.out.println("The sorted list is :");
		doOpen(addressBookName);
	}

	
		
	/**
	 * Method to CREATE A NEW ADDRESS book and saving the track of newly created address book in the JSON file named "addressBookList"
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doNew(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		 addressBookList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		//Creating empty addressBook
		 File file = new File(template + addressBookName + ".json");
		 addressBookList.add(file.toString());
		 mapper.writeValue(file,addressBook.personList);
		//Adding new address book to the addressBookList
		 mapper.writeValue((new File(bookList)),addressBookList);
}

	

	
	/**
	 * Method to VIEW an adressBook
	 * 
	 * @param addressBookNameOpen
	 * @throws java.io.IOException
	 * @throws java.lang.ClassCastException
	 * @throws java.lang.ClassNotFoundException
	 * @throws java.lang.InterruptedException
	 * @throws java.lang.SecurityException
	 * @throws ParseException
	 */
	public void doOpen(String addressBookNameOpen)throws java.io.IOException, java.lang.ClassCastException, java.lang.ClassNotFoundException,
			java.lang.InterruptedException, java.lang.SecurityException, ParseException {

		File fileOpen = findAddressBook(addressBookNameOpen);
		if(fileOpen!=null) {
		System.out.println("The address book details are shown below: ");
		personList=AddressUtility.parseJSONArray(fileOpen,Person.class);
		for(int i=0 ;i<personList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((personList.get(i))));
		}
		}
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
		if(file!=null) {
		System.out.println("Enter the index of the person");
		int index = Utility.userInputInteger();
		System.out.println(addressBook.getFullNameOfPerson(index, file));
		}
	}

	
	/**
	 * Method to find the number of person in the address book
	 * @param addressBookName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void getNumberOfPerson(String addressBookName) throws FileNotFoundException, IOException, ParseException{
		File file=new File(template+addressBookName+".json");
		System.out.println("The number of persons in the address book : ");
		System.out.println(addressBook.getNumberOfPersons(file));
		
}
	
	
	
	
	/**
	 * Method to FIND ADDRESS BOOK from the address book list
	 * 
	 * @param addressBookName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public File findAddressBook(String addressBookName) throws FileNotFoundException, IOException, ParseException {

		// parse to select multiple address books
		addressBookList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		if(addressBookList.contains(template + addressBookName + ".json")) {
			int index = addressBookList.indexOf(template + addressBookName + ".json");
			return new File(addressBookList.get(index));
		}
		System.out.println("Sorry!!! The address book you are looking for doesn't exist..");
		return null;
		}

	
	
	
	
	/**
	 * Method to DISPLAY address book
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void displayAddressBookList() throws FileNotFoundException, IOException, ParseException {
		System.out.println("The addressBooks available with us is displayed below:");
		addressBookList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		for(int i=0 ;i<addressBookList.size();i++) {
			System.out.println(addressBookList.get(i));
		}
	}

	
	
	/**
	 * Method to DELETE a particular address book 
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
		addressBookList= mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		int index = addressBookList.indexOf(template + addressBookName + ".json");
		addressBookList.remove(index);
		System.out.println("Are you sure you want to delete??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			addressBook.doSave(new File(bookList),addressBookList);
			System.out.println("Deleted Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
		}

	}



