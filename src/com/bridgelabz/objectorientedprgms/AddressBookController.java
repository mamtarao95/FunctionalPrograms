package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookController {
	static String template = "/home/administrator/mamta-workspace/Basicjavaprograms/";
	static String bookList="/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json";
	AddressBook addressBook = new AddressBook();
	LinkedList<String> addressBookList = new LinkedList<String>();
	ArrayList<Object> arrayList = new ArrayList<Object>();
	ArrayList<String> newList = new ArrayList<String>();
	ObjectMapper mapper = new ObjectMapper();
	
	
	
	
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
		System.out.println("Enter the index position of the person you want to delete ");
		int index = Utility.userInputInteger();
		addressBook.removePerson(index, file);
		doOpen(addressBookNameOpen);
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
		addressBook.sortByKey(file,"lastName");
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
		addressBook.sortByKey(file,"zip");
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
		 
		//Parsing the addressBookList file to get the list of addressBook
		/*JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(bookList));
		JSONArray array = (JSONArray) obj;
		for (int i = 0; i < array.size(); i++) {
			newList.add((String) array.get(i));
		}*/
		
		newList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});

		//Creating empty addressBook
		
		File file = new File(template + addressBookName + ".json");
		newList.add(file.toString());
		mapper.writeValue(file, addressBook.personList);

		//Adding new address book to the addressBookList
		mapper.writeValue((new File(bookList)), newList);

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
	public void doOpen(String addressBookNameOpen)
			throws java.io.IOException, java.lang.ClassCastException, java.lang.ClassNotFoundException,
			java.lang.InterruptedException, java.lang.SecurityException, ParseException {

		File fileOpen = findAddressBook(addressBookNameOpen);
		System.out.println("The address book details are shown below: ");
		arrayList=addressBook.parseJSON(fileOpen);
		for(int i=0 ;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
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
		System.out.println("Enter the index of the person");
		int index = Utility.userInputInteger();
		System.out.println(addressBook.getFullNameOfPerson(index, file));
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
		newList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		int index = newList.indexOf(template + addressBookName + ".json");
		return new File(newList.get(index));
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
		newList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		for(int i=0 ;i<newList.size();i++) {
			System.out.println(newList.get(i));
		}
	}

	
	
	/**
	 * Method to DELETE a particular address book
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
		newList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		int index = newList.indexOf(template + addressBookName + ".json");
		newList.remove(index);
		System.out.println("Are you sure you want to delete??(Y/N)");
		String result = Utility.userInputString();
		if (result.equals("Y")) {
			addressBook.doSave(new File(bookList),newList);
		}

	}

}
