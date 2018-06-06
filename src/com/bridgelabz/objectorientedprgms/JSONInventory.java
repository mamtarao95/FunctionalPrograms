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

import java.io.FileReader;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONInventory {

	public static void main(String[] args) throws Exception{
		    Object object=new JSONParser().parse(new FileReader("/home/administrator/Documents/myjson.json"));
		    JSONObject jsonoobj=(JSONObject)object;
		    //System.out.println(jsonoobj.toString());
		 @SuppressWarnings("unchecked")
		    Set<String> keys=jsonoobj.keySet();
		     for (String inventorykeys : keys) {
		        JSONArray inventoryarray=(JSONArray)jsonoobj.get(inventorykeys);
		        long totalprice=0;
		        for (Object object2 : inventoryarray) {
		        JSONObject inventory=(JSONObject)object2;
		        System.out.println(inventory.toString());
		       
		        long weight=(long)inventory.get("Weight");
		        long price=(long)inventory.get("Price");
		        totalprice+=(weight*price);
		        }
		        System.out.println();
		        System.out.println("Price of "+inventorykeys+" is "+totalprice);
		    }   
		}
}
	

