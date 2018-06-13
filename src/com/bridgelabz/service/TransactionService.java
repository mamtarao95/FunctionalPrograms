/*******************************************************************************
 *  Purpose: This interface provides TransactionClass Services 
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

public interface TransactionService {
	public void showCustomers() throws JsonParseException, JsonMappingException, IOException;
	public void showStock() throws JsonParseException, JsonMappingException, IOException;
	public void buy(String stockSymbol) throws JsonParseException, JsonMappingException, IOException;
	public void printReport() throws JsonParseException, JsonMappingException, IOException ;
	public void viewStockSymbolTrack() throws JsonParseException, JsonMappingException, IOException;
	public void viewDateTimeTrack() throws JsonParseException, JsonMappingException, IOException;
}
