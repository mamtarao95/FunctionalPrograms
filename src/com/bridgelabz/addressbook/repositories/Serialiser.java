/******************************************************************************
 *  Purpose:This program provides Serialiser interface
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.addressbook.repositories;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.models.Person;

public interface Serialiser {

	/**Method to create a new address book
	 *
	 * {@inheritDoc}
	 * 
	 * @param addressBookName
	 * 			The Name of the addressbook
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 */
	public void createBook(String addressBookName)
			throws JsonGenerationException, JsonMappingException, IOException, SQLException, PropertyVetoException;

	/**Method to add a person to addressbook
	 * 
	 * {@inheritDoc}
	 * 
	 * @param person
	 * 		Person object to be added to addressbook 
	 * @param addressbookName
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 */
	public void addPerson(Person person, String addressbookName)
			throws FileNotFoundException, IOException, ParseException, SQLException, PropertyVetoException;

	/**Method to delete an addressbook
	 * 
	 * {@inheritDoc}
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws PropertyVetoException
	 */
	public void deleteAddressBook() throws SQLException, IOException, PropertyVetoException;

	/**Method tp delete a person from addressbook
	 *
	 * {@inheritDoc}
	 * 
	 * @param addressBookName
	 * @throws SQLException
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @throws ParseException
	 */
	public void deletePerson(String addressBookName)
			throws SQLException, IOException, PropertyVetoException, ParseException;

	/**Method to view aparticular addressbook
	 *
	 * {@inheritDoc}
	 * 
	 * @param addressBookNameOpen
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 */
	public void viewAddressbook(String addressBookNameOpen) throws JsonGenerationException, JsonMappingException,
			IOException, ParseException, SQLException, PropertyVetoException;

	/**Method to update a person's details
	 * 
	 * {@inheritDoc}
	 * 
	 * @param addressBookName
	 * @param inputs
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws PropertyVetoException
	 */
	public void updatePerson(String addressBookName, String[] inputs) throws JsonGenerationException,
			JsonMappingException, IOException, ParseException, SQLException, PropertyVetoException;
}
