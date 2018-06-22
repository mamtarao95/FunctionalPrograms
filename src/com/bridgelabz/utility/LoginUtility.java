package com.bridgelabz.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.loginformproject.models.User;

public class LoginUtility {

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

	public static Connection EstablishConn() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "dbuser",
					"password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static User insertValues() {
		User user = new User();
		System.out.println("Enter username");
		String userName = userInputString();
		System.out.println("Enter password");
		System.out.println("Password must be 8 char long,Atleast 1 special char");
		System.out.println("Atleast a number,Atleast a small letter alphabet and a capital letter alphabet...");
		String password = userInputString();
		boolean valid = validatePassword(password);
		if (valid) {
			System.out.println("Enter mobile number");
			String mobileNumber = userInputString();
			user.setUserName(userName);
			user.setPassword(password);
			user.setMobileNumber(mobileNumber);
			return user;
		} else {
			System.out.println("Password is not valid. Check constraints for password field.Try again");
		}
		return null;

	}

	public static boolean validatePassword(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return password.matches(pattern);
	}
}
