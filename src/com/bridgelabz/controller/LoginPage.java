package com.bridgelabz.controller;

import java.sql.SQLException;
import com.bridgelabz.seviceimplementation.LoginServiceImplementaion;
import com.bridgelabz.utility.LoginUtility;

public class LoginPage {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		LoginServiceImplementaion loginServiceImplementaion = new LoginServiceImplementaion();
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
				loginServiceImplementaion.register();
				break;

			case 2:
				loginServiceImplementaion.login();
				break;
			default:
				System.out.println("Exiting login page!!!");
				keepOn = false;
			}

		}

	}
}
