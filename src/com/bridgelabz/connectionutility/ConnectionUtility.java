package com.bridgelabz.connectionutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectionUtility {
	
	static Scanner scanner=new Scanner(System.in);
	/*
	 * Method to take user input as long
	 */
	public static Long userInputLong() {
		return scanner.nextLong();

	}

	public static String userInputString() {
		return scanner.next();
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

	
	
	
	public static Connection establishConn() {
	Connection con =null ;
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false","dbuser","password");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

return con;
}
}
