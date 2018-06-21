package com.bridgelabz.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CallabaleStatementSample {
	
	public static void main(String[] args) throws ClassNotFoundException {
		CallableStatement callableStatement = null;
		ResultSet rs=null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "dbuser", "password");
		callableStatement=con.prepareCall("{call GetOfficeByCountry(?)}");
		callableStatement.setString(1, "Belgium");
		System.out.println("Stored procedure called successfully!");
		
		rs = callableStatement.executeQuery();
		while(rs.next()) {
			
			System.out.println("officeCode: "+rs.getInt(1)+" City: "+rs.getString(2)+" State: "+rs.getString(3)+" Country: "+rs.getString(4));
		}
	

         

	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {

				callableStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
		}
	

