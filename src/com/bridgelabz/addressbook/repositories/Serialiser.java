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

	
	public void createBook(String addressBookName)
			throws JsonGenerationException, JsonMappingException, IOException, SQLException, PropertyVetoException, ClassNotFoundException;

	
	public void addPerson(Person person, String addressbookName)
			throws FileNotFoundException, IOException, ParseException, SQLException, PropertyVetoException, ClassNotFoundException;


	public void deleteAddressBook() throws SQLException, IOException, PropertyVetoException, ClassNotFoundException;

	
	public void deletePerson(String addressBookName)
			throws SQLException, IOException, PropertyVetoException, ParseException, ClassNotFoundException;

	
	public void viewAddressbook(String addressBookNameOpen) throws JsonGenerationException, JsonMappingException,
			IOException, ParseException, SQLException, PropertyVetoException, ClassNotFoundException;

	public void updatePerson(String addressBookName) throws JsonGenerationException,JsonMappingException, IOException, ParseException, SQLException, PropertyVetoException, ClassNotFoundException;
	
	public void saveBook(String addressbook) throws SQLException, IOException, PropertyVetoException, ClassNotFoundException;
	
	public void readBook(String addressbook) throws SQLException, IOException, PropertyVetoException, ClassNotFoundException;
	public void  viewAddBookList() throws ClassNotFoundException, SQLException, IOException, PropertyVetoException;
}


