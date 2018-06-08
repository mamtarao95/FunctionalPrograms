/*******************************************************************************
 *  Purpose: This program reads and write a JSON inventory management file and calculate value of each inventory
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class InventoryUtility {
	static InventoryFactory inventoryFactory=new InventoryFactory();
	static ObjectMapper map = new ObjectMapper();
    static long productValue = 0;
	static long totalValue = 0;
    
	public void readWriteJsonInventory(File file) throws FileNotFoundException, IOException, ParseException {
	
	ProductDetails rice = new ProductDetails();
    System.out.println("Enter the variety of rice products you want");
    int riceVariety=Utility.userInputInteger();
    for (int i = 0; i < riceVariety; i++) {
    	 rice =Utility. productMethod();
    	 inventoryFactory.riceList.add(rice);
     }
	
	ProductDetails wheat = new ProductDetails();
    System.out.println("Enter the variety of wheat products you want");
    int wheatVariety=Utility.userInputInteger();
    for (int i = 0; i < wheatVariety; i++) {
    	 wheat = Utility.productMethod();
    	 inventoryFactory.wheatList.add(wheat);
     }
    
    ProductDetails pulse = new ProductDetails();
    System.out.println("Enter the variety of pulse products you want");
    int pulseVariety=Utility.userInputInteger();
    for (int i = 0; i < pulseVariety; i++) {
    	 pulse = Utility.productMethod();
    	 inventoryFactory.pulseList.add(pulse);
     }
    
    //writing to the JSON file
	 map.writeValue((file),inventoryFactory);

	//reads from the JSON file
     JSONParser parser = new JSONParser();
     Object obj = parser.parse(new FileReader(file));
     JSONObject jsonObject = (JSONObject) obj;
     System.out.println(jsonObject);
     String[] inventoryObjects= {"riceList","wheatList","pulseList"};
     for(int i=0 ; i<3 ; i++) {
     JSONArray array = (JSONArray) jsonObject.get(inventoryObjects[i]);
     for (int j = 0; j <array.size(); j++) {
         JSONObject obstock = (JSONObject) (array.get(j));
         totalValue += ((long) obstock.get("productPrice")) * ((long) obstock.get("productWeight"));
         productValue= ((long) obstock.get("productPrice")) * ((long) obstock.get("productWeight"));
         System.out.println("The value of "+ (j+1)+" no. product of "+inventoryObjects[i]+" inventory is "+ productValue);
          }
     }
     System.out.println("the total stock value is"+  totalValue);
    
 }
}
	

