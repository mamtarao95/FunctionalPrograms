package com.bridgelabz.loginformproject.services;

import java.sql.SQLException;

public interface UserService {
	public void login() throws SQLException, ClassNotFoundException;

	public void register() throws SQLException, ClassNotFoundException;

}
