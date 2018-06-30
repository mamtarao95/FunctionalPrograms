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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.models.Status;
import com.bridgelabz.addressbook.utility.AddressUtility;
import com.bridgelabz.addressbook.utility.DataSource;

public class JDBCSerialiserImplementation implements Serialiser {
	private static Connection connection = null;
	private static ResultSet resultSet = null;
	private static Statement Statement = null;
	private static PreparedStatement preparedStatement = null;
	static List<Person> personList = new ArrayList<>();

	/**
	 * Method to get the pooled connection
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws PropertyVetoException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()
			throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook?useSSL=false", "dbuser",
				"password");
		return connection;
	}

	public void readBook(String addressbookName)
			throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {

		String query = "select * from " + addressbookName;
		Statement = getConnection().createStatement();
		resultSet = Statement.executeQuery(query);
		while (resultSet.next()) {
			Person person = new Person();
			person.setStatus(Status.DEFAULT);
			person.setFirstName(resultSet.getString(2));
			person.setLastName(resultSet.getString(3));
			person.setAddress(resultSet.getString(4));
			person.setCity(resultSet.getString(5));
			person.setState(resultSet.getString(6));
			person.setZip(resultSet.getString(7));
			person.setPhone(resultSet.getString(8));

			personList.add(person);

		}
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
			throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {
		person.setStatus(Status.ADD);
		personList.add(person);
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i).getFirstName());
			System.out.println(personList.get(i).getLastName());
			System.out.println("-----");
		}
		System.out.println("Person marked for adding");
		closeConnection();

	}

	@Override
	public void deletePerson(String addressBookName)
			throws SQLException, IOException, PropertyVetoException, ParseException, ClassNotFoundException {
		System.out.println("We have following persons in the address book:  ");
		viewAddressbook(addressBookName);
		System.out.println("Enter name of full name of person you want to delete: ");
		AddressUtility.userInputStringLine();
		String personname = AddressUtility.userInputStringLine();
		String[] nameStr = personname.split(" ");
		System.out.println("...........");
		System.out.println(nameStr[0]);
		System.out.println(nameStr[1]);
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i).getFirstName());
			System.out.println(personList.get(i).getLastName());
			System.out.println("-----");
		}

		for (int i = 0; i < personList.size(); i++) {

			if (personList.get(i).getFirstName().equals(nameStr[0])
					&& personList.get(i).getLastName().equals(nameStr[1])) {
				personList.get(i).setStatus(Status.DELETE);
				System.out.println("status delset");
			}
		}
		System.out.println("Person marked for deleting");

	}

	@Override
	public void deleteAddressBook() throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {
		System.out.println("Enter the addressbook name ypu want to delete");
		String addressBook = AddressUtility.userInputString();
		String query1 = "drop table " + addressBook + ";";
		Statement statement = getConnection().createStatement();
		statement.executeUpdate(query1);

	}

	@Override
	public void createBook(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException,
			SQLException, PropertyVetoException, ClassNotFoundException {

		String query = "create table " + addressBookName
				+ "(personid int(3) auto_increment primary key,firstName varchar(20) unique,lastName varchar(30),address varchar(30),city varchar(20),state varchar(20),zip varchar(20),phone varchar(25))";
		Statement statement = getConnection().createStatement();
		statement.execute(query);
		System.out.println("Addressbook created successfully");
		closeConnection();

	}

	@Override
	public void viewAddressbook(String addressBookName) throws JsonGenerationException, JsonMappingException,
			IOException, ParseException, SQLException, PropertyVetoException, ClassNotFoundException {
		String query = "select * from " + addressBookName;
		Statement statement = getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println("Person id: " + resultSet.getInt(1));
			System.out.println("FirstName: " + resultSet.getString(2));
			System.out.println("LastName: " + resultSet.getString(3));
			System.out.println("Address: " + resultSet.getString(4));
			System.out.println("City: " + resultSet.getString(5));
			System.out.println("State: " + resultSet.getString(6));
			System.out.println("ZipCode: " + resultSet.getString(7));
			System.out.println("PhoneNum: " + resultSet.getString(8));
			System.out.println("*******************");
		}
		closeConnection();
	}

	@Override
	public void updatePerson(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException,
			ParseException, SQLException, PropertyVetoException, ClassNotFoundException {
		viewAddressbook(addressBookName);
		Person person = new Person();
		System.out.println("Enter name of full name of person you want to update: ");
		AddressUtility.userInputStringLine();
		String personname = AddressUtility.userInputStringLine();
		String[] nameStr = personname.split(" ");
		System.out.println(nameStr[0]);
		System.out.println(nameStr[1]);
		String[] inputs = AddressUtility.askForInputsUpdate();

		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(nameStr[0])
					&& personList.get(i).getLastName().equals(nameStr[1])) {
				person.setFirstName(personList.get(i).getFirstName());
				person.setLastName(personList.get(i).getLastName());
				person.setAddress(inputs[0]);
				person.setCity(inputs[1]);
				person.setState(inputs[2]);
				person.setZip(inputs[3]);
				person.setPhone(inputs[4]);
				person.setStatus(Status.UPDATE);
				personList.add(i, person);
				break;

			}
		}
		System.out.println("person marked for updating");

	}

	public void viewEditedAddressBook() {
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i).getFirstName());
			System.out.println(personList.get(i).getLastName());
			System.out.println(personList.get(i).getAddress());
			System.out.println(personList.get(i).getCity());
			System.out.println(personList.get(i).getState());
			System.out.println(personList.get(i).getZip());
			System.out.println(personList.get(i).getPhone());
			System.out.println("*****************");
		}
	}

	public void saveBook(String addressbook)
			throws SQLException, IOException, PropertyVetoException, ClassNotFoundException {
		for (int index = 0; index < personList.size(); index++) {
			if (personList.get(index).getStatus().equals(Status.ADD)) {
				String query = "insert into " + addressbook + " values(?,?,?,?,?,?,?,?)";

				preparedStatement = getConnection().prepareStatement(query);
				preparedStatement.setInt(1, 0);
				preparedStatement.setString(2, personList.get(index).getFirstName());
				preparedStatement.setString(3, personList.get(index).getLastName());
				preparedStatement.setString(4, personList.get(index).getAddress());
				preparedStatement.setString(5, personList.get(index).getCity());
				preparedStatement.setString(6, personList.get(index).getState());
				preparedStatement.setString(7, personList.get(index).getZip());
				preparedStatement.setString(8, personList.get(index).getPhone());
				int resultSet = preparedStatement.executeUpdate();
				if (resultSet != 0) {
					System.out.println("Person added successfully");
				}
				closeConnection();

			}

			else if (personList.get(index).getStatus().equals(Status.DELETE)) {
				Statement = getConnection().createStatement();
				String firstname = personList.get(index).getFirstName();
				String lastname = personList.get(index).getLastName();
				String query1 = "delete from " + addressbook + " where firstName='" + firstname + "' and lastName='"
						+ lastname + "'";
				Statement.execute(query1);
				System.out.println("deleting successfully");
				closeConnection();
			}

			else if (personList.get(index).getStatus().equals(Status.UPDATE)) {
				Statement = getConnection().createStatement();
				String firstname = personList.get(index).getFirstName();
				String lastname = personList.get(index).getLastName();
				String query1 = "update " + addressbook + " set address='" + personList.get(index).getAddress()
						+ "',city='" + personList.get(index).getCity() + "',state='" + personList.get(index).getState()
						+ "',zip='" + personList.get(index).getZip() + "',phone='" + personList.get(index).getPhone()
						+ "' where firstName='" + firstname + "' and lastName='" + lastname + "'";
				Statement.execute(query1);
				System.out.println("Updated successfully");
				closeConnection();
			}
		}

	}

	public void viewAddBookList() throws ClassNotFoundException, SQLException, IOException, PropertyVetoException {
		Statement = getConnection().createStatement();
		String query = "show tables";
		resultSet = Statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}

}
