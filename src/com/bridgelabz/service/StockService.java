/*******************************************************************************
 *  Purpose: This interface provides StockClass Services 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.service;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public interface StockService {
	
	public void addStock() throws JsonGenerationException, JsonMappingException, IOException;
	public void deleteStock() throws JsonGenerationException, JsonMappingException, IOException;
}
