package com.bridgelabz.seviceimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;
import com.bridgelabz.services.loginService;
import com.bridgelabz.utility.LoginUtility;

public class LoginServiceImplementaion implements loginService {

	Connection con = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.services.loginService#login()
	 */
	@Override
	public void login() throws SQLException, ClassNotFoundException {

		boolean userNameExist = false;
		boolean passwordExist = false;
		con = LoginUtility.EstablishConn();
		String query = "select * from loginDetails";
		preparedStatement = con.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		System.out.println("Enter user name ");
		String userName = LoginUtility.userInputString();

		while (resultSet.next()) {

			if (userName.equals(resultSet.getString(2))) {
				userNameExist = true;
			}
		}

		if (userNameExist) {
			System.out.println("Enter password");
			String pwd = LoginUtility.userInputString();
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				if (pwd.equals(resultSet.getString(3))) {

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

			register();
		}

	}

	
	
	@Override
	public void register() throws SQLException, ClassNotFoundException {
		String query = "insert into loginDetails values(?,?,?,?)";
		con = LoginUtility.EstablishConn();
		preparedStatement = con.prepareStatement(query);
		User user = LoginUtility.insertValues();
		if (user != null) {
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getMobileNumber());
			int rs1 = preparedStatement.executeUpdate();
			if (rs1 != 0) {
				System.out.println("Registered successfully");
			}
		} else {
			System.out.println("Registeration unsuccessfull!! Try again");
		}

	}

	
	
	@Override
	public void forgotPassword(String userName) throws SQLException {
		boolean search = false;
		PreparedStatement pstmt = null;
		String query = "select * from loginDetails";
		String query1 = "update logindetails set password=? where user_name=?";
		pstmt = con.prepareStatement(query1);
		preparedStatement = con.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();

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
}
