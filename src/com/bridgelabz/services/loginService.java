package com.bridgelabz.services;

import java.sql.SQLException;

public interface loginService {
	public void login() throws SQLException, ClassNotFoundException;

	public void register() throws SQLException, ClassNotFoundException;

	public void forgotPassword(String userName) throws SQLException;

}
