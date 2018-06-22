package com.bridgelabz.loginformproject.services;

import java.sql.SQLException;
import com.bridgelabz.loginformproject.models.User;
import com.bridgelabz.loginformproject.repositories.RepositoryFactory;
import com.bridgelabz.loginformproject.repositories.UserRepository;
import com.bridgelabz.utility.LoginUtility;

public class UserServiceImplementation implements UserService {
	UserRepository userRepository;

	public UserServiceImplementation(String statementType) {
	userRepository=RepositoryFactory.getStatement(statementType);
	}

	
	@Override
	public void login() throws SQLException, ClassNotFoundException {
		System.out.println("Enter user name ");
		String userName = LoginUtility.userInputString();
		System.out.println("Enter password");
		String password = LoginUtility.userInputString();
		userRepository.login(userName,password);
		
		
		
	}

	@Override
	public void register() throws SQLException, ClassNotFoundException {
		User user=LoginUtility.insertValues();
		userRepository.register(user);
		
		
	}


}
