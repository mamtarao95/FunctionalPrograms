/*******************************************************************************
 *  Purpose: This program reads a JSON inventory management file.
 *   Creates Inventory Object from JSON. Calculate the value for every Inventory
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
import org.json.simple.parser.ParseException;

public class JSONInventoryManagement {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		File file=new File("/home/administrator/Documents/inventoryReport.json");
	    InventoryUtility inventoryUtility=new  InventoryUtility();
	    inventoryUtility.readWriteJsonInventory(file);
		}
}
	
	

