/*******************************************************************************
 *  Purpose: This interface provides CustomerClass Services 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface CustomerService {
	
	public void addCustomer() throws JsonParseException, JsonMappingException, IOException;
	public void deleteCustomer() throws JsonParseException, JsonMappingException, IOException;
	public void updateCustomer(int noOfShares, int amountOfShares,String customerID) throws JsonParseException, JsonMappingException, IOException;

}
