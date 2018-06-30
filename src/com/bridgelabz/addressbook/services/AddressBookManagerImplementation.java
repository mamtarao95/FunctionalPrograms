/******************************************************************************
 *  Purpose:Program for the addressBookManager, manages the address book
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.addressbook.services;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.repositories.SerialiserFactory;
import com.bridgelabz.addressbook.utility.AddressUtility;
import com.bridgelabz.addressbook.repositories.Serialiser;;

public class AddressBookManagerImplementation{
	Serialiser serialiserFactoryInterface;
	AddressBookImplementation addressBook = new AddressBookImplementation();
	ObjectMapper mapper = new ObjectMapper();
	AddressBookImplementation addressBookImplementation=new AddressBookImplementation();
	AddressUtility addressUtility= new AddressUtility();
	public ArrayList<Person> personList = new ArrayList<Person>();
	public ArrayList<String> addressBookList = new ArrayList<String>();
	static String template = "/home/administrator/mamta-workspace/Basicjavaprograms/";
	static String bookList="/home/administrator/mamta-workspace/Basicjavaprograms/addressBookList.json";
	static Serialiser serialiser;
	

	
	/**
	 * Method to CREATE A NEW ADDRESS book and saving the track of newly created address book in the JSON file named "addressBookList"
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException
	 */
	
	public void createAddressBook(String serialiseType,String addressBookName) throws JsonGenerationException, JsonMappingException, IOException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		serialiser.createBook(addressBookName);
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

public void viewAddBookList(String serialiseType ) throws ClassNotFoundException, SQLException, IOException, PropertyVetoException {
	serialiser=SerialiserFactory.getSerialiser(serialiseType);
	serialiser.viewAddBookList();
	
}


	/**Method to delete addressbook
	 * @param serialiseType
	 * @throws SQLException
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException 
	 */
	public void deleteAddressBook(String serialiseType) throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		serialiser.deleteAddressBook();
		
		
	}


	/**Method to open existing addressbook
	 * @param serialiseType
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException 
	 */
	public void openExistingAdBook(String serialiseType) throws JsonGenerationException, JsonMappingException, IOException, ParseException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		System.out.println("Enter the address book you want to view ");
		String addressBookName=AddressUtility.userInputString();
		serialiser.viewAddressbook(addressBookName);
		
	}


	/**Method to add person
	 * @param serialiseType
	 * @param addressbookName
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException 
	 */
	public void addPerson(String serialiseType,String addressbookName) throws JsonGenerationException, JsonMappingException, SecurityException, IOException, ParseException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		addressBookImplementation.addPerson(serialiser,addressbookName);

		
	}



	
	/**Method to remove person
	 * @param serialiseType
	 * @param addressbookName
	 * @throws FileNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException 
	 */
	public void removePerson(String serialiseType,String addressbookName) throws FileNotFoundException, SecurityException, IOException, ParseException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		addressBookImplementation.removePerson(serialiser,addressbookName);
		
	}


public void saveBook(String serialiseType,String addressbookName) throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {
	serialiser=SerialiserFactory.getSerialiser(serialiseType);
	serialiser.saveBook(addressbookName);

	
}

	/**Method to update person
	 * @param serialiseType
	 * @param addressbookName
	 * @throws FileNotFoundException
	 * @throws SecurityException
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException 
	 */
	public void updatePerson(String serialiseType,String addressbookName) throws FileNotFoundException, SecurityException, IOException, ParseException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
	
		serialiser=SerialiserFactory.getSerialiser(serialiseType);
		addressBookImplementation.updatePerson(serialiser, addressbookName);
	}

public void readBook(String serialiseType,String addressbookName) throws ClassNotFoundException, SQLException, IOException, PropertyVetoException {
	serialiser=SerialiserFactory.getSerialiser(serialiseType);
	serialiser.readBook(addressbookName);
	
}

	}



