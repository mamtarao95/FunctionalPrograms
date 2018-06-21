package com.bridgelabz.jdbc;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.bridgelabz.connectionutility.ConnectionUtility;

public class Transaction {

	public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Savepoint savePoint = null;
		String insert1 = "insert into employee values(?,?)";
		String insert2 = "insert into student values(?,?)";
		System.out.println("Enter employee name");
		String empName = ConnectionUtility.userInputString();
		System.out.println("Enter the employee salary");
		int salary = ConnectionUtility.userInputInteger();
		System.out.println("Enter Student id");
		int studentId = ConnectionUtility.userInputInteger();
		System.out.println("Enter the student name");
		String studentName = ConnectionUtility.userInputString();
		connection = DataSource.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			pstmt1 = connection.prepareStatement(insert1);
			pstmt1.setString(1, empName);
			pstmt1.setInt(2, salary);
			pstmt1.executeUpdate();
			savePoint= connection.setSavepoint();

			pstmt2 = connection.prepareStatement(insert2);
			pstmt2.setInt(1, studentId);
			pstmt2.setString(2, studentName);
			pstmt2.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback(savePoint);
				connection.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
