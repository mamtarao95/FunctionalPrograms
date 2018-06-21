package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.bridgelabz.connectionutility.ConnectionUtility;

public class BatchProcessing {
	public static void main(String[] args) throws SQLException {
	    Connection connection=null;
	    Statement statement=null;
	    String insert="insert into loginDetails values(2,'mamta')";
	    String update="update student set id=1 where name='simran'";
	    String delete="delete from studentdetails where id=2";
	    try {
	    connection=ConnectionUtility.establishConn();
	    statement=connection.createStatement();
	   
	    statement.addBatch(insert);
	    statement.addBatch(update);
	    statement.addBatch(delete);

	    int[] array=statement.executeBatch();
	    for (int i:array) {
	        System.out.println(i);
	    }
	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	   
	    finally {
	        if(statement!=null) {
	            statement.close();
	        }
	        if(connection!=null) {
	            connection.close();
	        }
	    }
	   
	    }

}
