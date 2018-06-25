/******************************************************************************
 *  Purpose:This program provides JDBCSerilisation
 *
 *  @author  mamta
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.addressbook.repositories;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.utility.AddressUtility;
import com.bridgelabz.addressbook.utility.DataSource;

public class JDBCSerialiserImplementation implements Serialiser {
	 private Connection connection = null;
	 private ResultSet resultSet = null;
	 private Statement Statement = null;
	 private PreparedStatement preparedStatement = null;
	 private Person person;

	/**Method to get the pooled connection
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws PropertyVetoException
	 */
	public Connection getConnection() throws SQLException, IOException, PropertyVetoException {
		Connection connection = DataSource.getInstance().getConnection();
		return connection;
	}

	
	/**
	 * Method to close all the connections
	 */
	public void closeConnection() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		if (Statement != null) {
			try {
				Statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	
	@Override
	public void addPerson(Person person, String addressbookName)
			throws SQLException, IOException, PropertyVetoException {
		try {
			String query = "insert into " + addressbookName + " values(?,?,?,?,?,?,?,?)";

			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, person.getFirstName());
			preparedStatement.setString(3, person.getLastName());
			preparedStatement.setString(4, person.getAddress());
			preparedStatement.setString(5, person.getCity());
			preparedStatement.setString(6, person.getState());
			preparedStatement.setString(7, person.getZip());
			preparedStatement.setString(8, person.getPhone());
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet != 0)
				System.out.println("Person added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();

	}
	
	
	@Override
	public void deletePerson(String addressBookName) throws SQLException, IOException, PropertyVetoException {
		System.out.println("Enter the person id you want to delete");
		int personid = AddressUtility.userInputInteger();
		String query = "select * from " + addressBookName;
		Statement statement = getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			if (resultSet.getInt(1) == personid) {
				String query1 = "delete from " + addressBookName + " where personid=" + personid;
				statement.executeUpdate(query1);
			}
		}
		closeConnection();
	}

	
	@Override
	public void deleteAddressBook() throws SQLException, IOException, PropertyVetoException {
		System.out.println("Enter the addressbook name ypu want to delete");
		String addressBook = AddressUtility.userInputString();
		String query1 = "drop table " + addressBook + ";";
		Statement statement = getConnection().createStatement();
		statement.executeUpdate(query1);

	}
	
	
	@Override
	public void createBook(String addressBookName)
			throws JsonGenerationException, JsonMappingException, IOException, SQLException, PropertyVetoException {
		
		String query = "create table " + addressBookName
				+ "(personid int(3) auto_increment primary key,firstName varchar(20),lastName varchar(30),address varchar(30),city varchar(20),state varchar(20),zip varchar(20),phone varchar(25))";
		Statement statement = getConnection().createStatement();
		statement.execute(query);
		closeConnection();

	}


	@Override
	public void viewAddressbook(String addressBookName)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException, SQLException, PropertyVetoException {
		String query= "select * from " + addressBookName;
		Statement statement = getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println("Person id: "+resultSet.getInt(1));
			System.out.println("FirstName: "+resultSet.getString(2));
			System.out.println("LastName: "+resultSet.getString(3));
			System.out.println("Address: "+resultSet.getString(4));
			System.out.println("City: "+resultSet.getString(5));
			System.out.println("State: "+resultSet.getString(6));
			System.out.println("ZipCode: "+resultSet.getString(7));
			System.out.println("PhoneNum: "+resultSet.getString(8));
			System.out.println("*******************");
		}
		closeConnection();
	}

	@Override
	public void updatePerson(String addressBookName, String[] inputs)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException, SQLException, PropertyVetoException {
		String query= "select * from " + addressBookName;
		viewAddressbook(addressBookName);
		System.out.println("Enter id of person you want to update: ");
		int personid=AddressUtility.userInputInteger();
		String query1="update "+addressBookName+" set address='"+inputs[0]+"',city='"+inputs[1]+"',state='"+inputs[2]+"',zip='"+inputs[3]+"',phone='"+inputs[4]+ "' where personid="+personid;
		Statement statement = getConnection().createStatement();
		statement.executeQuery(query);
		statement.executeUpdate(query1);
		System.out.println("Updated successfully");
		closeConnection();
		
		
		
		
	}

	

}
