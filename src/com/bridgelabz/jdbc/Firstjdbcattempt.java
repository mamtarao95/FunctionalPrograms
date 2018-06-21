package com.bridgelabz.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;


public class Firstjdbcattempt {
	    /**
	     * @param args
	     * @throws SQLException
	     */
	    public static void main(String[] args)
	    {
	        Connection con=null;
	        PreparedStatement pstmt=null;
	        ResultSet rst=null;
	       
	         try {
	            Driver driveRef=new Driver();
	            // String dburl=
	             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","dbuser","password");
	             String query="insert into studentDetails values(3,'shruti','laxetti')";
	          
	             pstmt=con.prepareStatement(query);
	             pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         finally
	         {
	             
	                 try
	                 {
	                     if(con!=null)
	                         
	                    con.close();
	                     if(pstmt!=null)
	                     {
	                         pstmt.close();
	                     }
	                     if(rst!=null)
	                     {
	                         rst.close();
	                     }
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	             
	         }
	       
	         
	          
	             
	    }
	
	
	



}
