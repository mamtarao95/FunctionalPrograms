package com.bridgelabz.loginformproject.controllers;

import java.sql.SQLException;

import com.bridgelabz.loginformproject.services.UserServiceImplementation;
import com.bridgelabz.utility.LoginUtility;

public class LoginPage {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String typeOfStatement =args[0];
		
		
		boolean keepOn = true;
		System.out.println("Welcome to login page!! ");

		while (keepOn) {
			System.out.println("Enter your choice:");
			System.out.println("(1) - REGISTER");
			System.out.println("(2) - LOGIN");
			System.out.println("(3) - EXIT");

			int choice = LoginUtility.userInputInteger();
			switch (choice) {
			case 1:
				UserServiceImplementation userServiceImplementation=new UserServiceImplementation(typeOfStatement);
				userServiceImplementation.register();
				break;

			case 2:
				UserServiceImplementation userServiceImplementation1=new UserServiceImplementation(typeOfStatement);
				userServiceImplementation1.login();
				break;
			default:
				System.out.println("Exiting login page!!!");
				keepOn = false;
			}

		}

	}
}
