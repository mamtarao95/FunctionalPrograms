/******************************************************************************
 *  Purpose:Utility program for the addressBook application
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressUtility {
	public ArrayList<Object> arrayList = new ArrayList<Object>();
	public static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Method to take inputs from user regarding person's details for adding
	 * 
	 * @return String containing person's details
	 */
	public static String[] askForInputs() {
		System.out.println("Enter the first name of the person");
		String firstName = Utility.userInputString();

		System.out.println("Enter the last name of the person");
		String lastName = Utility.userInputString();

		System.out.println("Enter the address of the person");
		String address = Utility.userInputString();

		System.out.println("Enter the city of the person");
		String city = Utility.userInputString();

		System.out.println("Enter the state of the person");
		String state = Utility.userInputString();

		System.out.println("Enter the zipCode of the area");
		String zip = Utility.userInputString();

		System.out.println("Enter the phone number of the person");
		String phone = Utility.userInputString();

		String[] string = { firstName, lastName, address, city, state, zip, phone };
		return string;

	}

	/**
	 * Method to take inputs from user regarding person's details for updation
	 * 
	 * @return String containing person's details
	 */
	public static String[] askForInputsUpdate() {

		System.out.println("Enter the address of the person");
		String address = Utility.userInputString();

		System.out.println("Enter the city of the person");
		String city = Utility.userInputString();

		System.out.println("Enter the state of the person");
		String state = Utility.userInputString();

		System.out.println("Enter the zipCode of the area");
		String zip = Utility.userInputString();

		System.out.println("Enter the phone number of the person");
		String phone = Utility.userInputString();

		String[] string = { address, city, state, zip, phone };
		return string;

	}

	/**
	 * Method to parse the JSON file and store into the array list
	 * 
	 * @param file
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<T> arrayList = new ArrayList<T>();
		CollectionType javaType = mapper.getTypeFactory()
			      .constructCollectionType(List.class, clazz);
		arrayList = mapper.readValue(file, javaType);

		return arrayList;

	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Person> arrayList = parseJSONArray(new File("/home/administrator/mamta-workspace/Basicjavaprograms/friends.json"), Person.class);
	
	}

}
