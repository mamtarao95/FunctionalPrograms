package com.bridgelabz.loginformproject.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import com.bridgelabz.loginformproject.models.User;

public interface UserRepository {
	public Connection getConnection() throws ClassNotFoundException;
	public void register(User user) throws SQLException, ClassNotFoundException;
	public void login(String userName,String password) throws SQLException, ClassNotFoundException;
	public void forgotPassword(String userName) throws SQLException, ClassNotFoundException;
	public void closeConnection();
	

}
