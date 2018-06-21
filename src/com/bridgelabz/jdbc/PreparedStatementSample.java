package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementSample {
	public static void main(String[] args) throws ClassNotFoundException {

		PreparedStatement preparedStatement = null;

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "dbuser", "password");
			
			//To insert using preparedStatement
			/*preparedStatement = con.prepareStatement("insert into studentDetails values(?,?,?)");
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "pratik");
			preparedStatement.setString(3, "prakash");*/
			
			
			//TO UPDATE USING PREPARED STATEMENT
			/*preparedStatement  =con.prepareStatement("update studentDetails set id=? where firstName=?");
			preparedStatement.setInt(1,7);
			preparedStatement.setString(2,"sari");*/
		preparedStatement=con.prepareStatement("delete from studentDetails where id=?");  
		preparedStatement.setInt(1,7);
			
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {

				preparedStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
