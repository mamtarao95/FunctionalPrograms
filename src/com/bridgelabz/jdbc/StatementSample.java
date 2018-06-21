package com.bridgelabz.jdbc;

//import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StatementSample {

	public static void main(String[] args) throws Exception {

		Statement statement = null;
		ResultSet resultSet = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "dbuser", "password");
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from studentDetails");
		
			while (resultSet.next()) {
				// To display entire table of studenDetail
				
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
				//System.out.println(resultSet.getInt("id") + " " + resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
			}

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
