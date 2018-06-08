/*******************************************************************************
 *  Purpose: This program reads in Stock Names, Number of Share, Share Price.
 			 and prints a Stock Report with total value of each Stock and the total value of Stock
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import com.bridgelabz.util.Utility;

public class StockPortfolio {
 public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, org.json.simple.parser.ParseException {
	 File file=new File("/home/administrator/Documents/stockReport.json");
	 System.out.println("Enter number of stock");
     int number=Utility.userInputInteger();
     Utility.readWriteJSON(file,number);
	}
 }