package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataSample {
	public static void main(String[] args) throws ClassNotFoundException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection con = null;
		ResultSetMetaData rsmd=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "dbuser", "password");
			

			preparedStatement=con.prepareStatement("select * from studentDetails");  
			resultSet=preparedStatement.executeQuery();  
			 rsmd=resultSet.getMetaData();  
		  
		System.out.println("Total columns: "+rsmd.getColumnCount());  
		System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
		System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
		System.out.println("Column Table name: "+rsmd.getTableName(2)); 
		  
	
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
