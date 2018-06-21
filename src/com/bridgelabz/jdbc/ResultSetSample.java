package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetSample {
	public static void main(String[] args) throws ClassNotFoundException {
	
	Statement statement = null;
	ResultSet resultSet = null;
	Connection con = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "dbuser", "password");
		statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		resultSet = statement.executeQuery("select * from studentDetails");
	
			// To display entire table of studenDetail
			
			resultSet.absolute(1);  
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));  
			
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	finally {
		try {

			resultSet.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

}


