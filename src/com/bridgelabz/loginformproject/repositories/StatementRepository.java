package com.bridgelabz.loginformproject.repositories;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.loginformproject.models.User;
import com.bridgelabz.utility.LoginUtility;

public class StatementRepository implements UserRepository {
	static Connection connection = null;
	static ResultSet resultSet = null;
	static Statement Statement = null;

	@Override
	public Connection getConnection() throws ClassNotFoundException {
		connection = LoginUtility.EstablishConn();
		return connection;

	}

	@Override
	public void login(String UserName, String password) throws SQLException, ClassNotFoundException {
		System.out.println("hi i ama login of s");
		boolean userNameExist = false;
		boolean passwordExist = false;
		String query = "select * from loginDetails";
		Statement = getConnection().createStatement();
		resultSet = Statement.executeQuery(query);
		System.out.println("Enter user name ");
		String userName = LoginUtility.userInputString();

		while (resultSet.next()) {
			if (userName.equals(resultSet.getString(2))) {
				userNameExist = true;
			}
		}

		if (userNameExist) {
			resultSet = Statement.executeQuery(query);
			while (resultSet.next()) {

				if (password.equals(resultSet.getString(3))) {
					System.out.println("LOGIN SUCCESSFULL!!!");
					passwordExist = true;
				}
			}

			if (!passwordExist) {
				System.out.println("Invalid password");
				System.out.println("Forgot password???? (Y/N)");
				if (LoginUtility.userInputString().equalsIgnoreCase("Y")) {
					forgotPassword(userName);

				}
			}

		}
		if (!userNameExist) {
			System.out.println("Username does not exist.Kindly register!!");
			User user = LoginUtility.insertValues();
			register(user);
		}

	}

	public void register(User user) throws SQLException, ClassNotFoundException {
		System.out.println("hi register of s");

		Statement = getConnection().createStatement();
		if (user != null) {
			int rs1 = Statement.executeUpdate("insert into loginDetails values(" + "0" + ",'" + user.getUserName()
					+ "','" + user.getPassword() + "','" + user.getMobileNumber() + "'" + ")");

			if (rs1 != 0) {
				System.out.println("Registered successfully");
			}
		} else {
			System.out.println("Registeration unsuccessfull!! Try again");
		}

	}

	@Override
	public void forgotPassword(String userName) throws SQLException, ClassNotFoundException {
		boolean search = false;
		String query = "select * from loginDetails";
		String query1 = "update logindetails set password=? where user_name=?";
		Statement = getConnection().prepareStatement(query);
		Statement pstmt = getConnection().prepareStatement(query1);
		resultSet = Statement.executeQuery(query);

		System.out.println("Enter mobile number for verification");
		String mobNum = LoginUtility.userInputString();
		while (resultSet.next()) {
			if (resultSet.getString(2).equals(userName) && resultSet.getString(4).equals(mobNum)) {

				System.out.println("Your password is: " + resultSet.getString(3));
				search = true;
				break;

			}
		}
		if (!search) {
			System.out.println("Incorrect mobile number");
		}

	}

	@Override
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
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
