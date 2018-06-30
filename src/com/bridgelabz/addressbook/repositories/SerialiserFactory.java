/******************************************************************************
 *  Purpose:This program provides user interface for address book users
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.addressbook.repositories;

public class SerialiserFactory {

	public static Serialiser getSerialiser(String serialiserType) {

		if ((serialiserType).equalsIgnoreCase("JSON")) {
			return new JSONSerialiserImplementation();
		} else if ((serialiserType).equalsIgnoreCase("JDBC")) {
			return new JDBCSerialiserImplementation();
		}

		System.out.println("Invalid serialiser type!!!");
		return null;

	}
}
