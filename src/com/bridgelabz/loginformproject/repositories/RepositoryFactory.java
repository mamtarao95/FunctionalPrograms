package com.bridgelabz.loginformproject.repositories;


public class RepositoryFactory {
	
	public static UserRepository getStatement(String typeOfStatement){
		if("preparedstatement".equalsIgnoreCase(typeOfStatement)) 
			return new PreparedStatementRepository();
		else if("statement".equalsIgnoreCase(typeOfStatement))
			return new StatementRepository();
		
		return null;
	}

}
