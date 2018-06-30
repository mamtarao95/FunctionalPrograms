/******************************************************************************
 *  Purpose:This program is for AddressBook,manages list of person in the address book
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.addressbook.services;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.repositories.Serialiser;
import com.bridgelabz.addressbook.utility.AddressUtility;

public class AddressBookImplementation {
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
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void addPerson(Serialiser serialiser,String addressbookName) throws JsonGenerationException, JsonMappingException, IOException, ParseException,SecurityException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
		String[] personData=AddressUtility.askForInputs();
		Person person = new Person(personData[0],personData[1],personData[2],personData[3],personData[4],personData[5],personData[6]);
		serialiser.addPerson(person,addressbookName);
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
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void updatePerson(Serialiser serialiser,String addressbookName)
		throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser.updatePerson(addressbookName);
		
		
		
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
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void removePerson(Serialiser serialiser,String addressbookName)
			throws FileNotFoundException, IOException, ParseException, SecurityException, InterruptedException, SQLException, PropertyVetoException, ClassNotFoundException {
		serialiser.deletePerson(addressbookName);
	}

}
