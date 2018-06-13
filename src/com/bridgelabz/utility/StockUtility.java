/*******************************************************************************
 *  Purpose: This class provides StockUtility functions 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;

public class StockUtility {

	static ObjectMapper mapper = new ObjectMapper();

	static Scanner scanner = new Scanner(System.in);

	/*
	 * Method to take user input as string
	 */
	public static String userInputString() {
		return scanner.next();

	}

	/*
	 * Method to take user input as long
	 */
	public static Long userInputLong() {
		return scanner.nextLong();

	}

	public static String userInputStringLine() {
		return scanner.nextLine();
	}

	/*
	 * Method to take user input as integer
	 */
	public static int userInputInteger() {
		return scanner.nextInt();
	}

	/*
	 * Method to take user input as double
	 */
	public static Double userInputDouble() {
		return scanner.nextDouble();
	}

	/*
	 * Method to take user input as boolean
	 */
	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}

	/**
	 * Method to parse JSONArray and convert JSON Object to java object
	 * 
	 * @param file
	 *            JSONFile to be converted
	 * @param clazz
	 *            Class Object
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> LinkedList<T> parseJSONArray(File file, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		LinkedList<T> linkedList = new LinkedList<T>();
		ArrayList<T> tempList = new ArrayList<T>();
		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
		tempList = mapper.readValue(file, javaType);
		for (int i = 0; i < tempList.size(); i++) {
			linkedList.add(tempList.get(i));
		}
		return linkedList;
	}

	/**
	 * Method to take customer details from user
	 * 
	 * @return String[] of customer details
	 */
	public static String[] takeCustomerInputs() {
		System.out.println("Kindly enter the customer's details: ");
		System.out.println("Enter customer's name: ");
		StockUtility.userInputStringLine();
		String customerName = StockUtility.userInputStringLine();
		System.out.println("Enter customer's number of shares: ");
		int noOfShares = StockUtility.userInputInteger();
		System.out.println("Enter customer's amount of shares : ");
		double amountOfShares = StockUtility.userInputInteger();
		System.out.println("enter customer ID");
		String customerID = StockUtility.userInputString();

		String customerDetails[] = { customerName, Integer.toString(noOfShares), Double.toString(amountOfShares),
				customerID };
		return customerDetails;
	}

	/**
	 * Method to stock details from user
	 * 
	 * @return String[] of stock details
	 */
	public static String[] takeStockInputs() {
		System.out.println("Kindly enter the stock  details: ");
		System.out.println("Enter stock name: ");
		StockUtility.userInputStringLine();
		String stockSymbol = StockUtility.userInputStringLine();
		System.out.println("Enter stock's number of shares: ");
		int noOfShares = StockUtility.userInputInteger();
		System.out.println("Enter price of shares : ");
		double priceOfShares = StockUtility.userInputInteger();
		String stockDetails[] = { stockSymbol, Integer.toString(noOfShares), Double.toString(priceOfShares) };
		return stockDetails;
	}

	/**
	 * Method to return timeStamp
	 * 
	 * @return String timeStamp
	 */
	public static String timeStamp() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (formatter.format(ts));
	}
}
