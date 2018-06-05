package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class JSONInventoryManagement {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		long productValue = 0;
		long totalValue = 0;
		
		InventoryFactory inventoryFactory=new InventoryFactory();
	     ObjectMapper map = new ObjectMapper();
	     ProductDetails productDetails=new ProductDetails();
	     File file=new File("/home/administrator/Documents/inventoryReport.json");
	
	    ProductDetails rice = new ProductDetails();
	    System.out.println("Enter the variety of rice products you want");
	    int riceVariety=Utility.userInputInteger();
	    for (int i = 0; i < riceVariety; i++) {
	    	 rice = productMethod();
	    	 inventoryFactory.riceList.add(rice);
	     }
		
		ProductDetails wheat = new ProductDetails();
	    System.out.println("Enter the variety of wheat products you want");
	    int wheatVariety=Utility.userInputInteger();
	    for (int i = 0; i < wheatVariety; i++) {
	    	 wheat = productMethod();
	    	 inventoryFactory.wheatList.add(wheat);
	     }
	    
	    ProductDetails pulse = new ProductDetails();
	    System.out.println("Enter the variety of pulse products you want");
	    int pulseVariety=Utility.userInputInteger();
	    for (int i = 0; i < pulseVariety; i++) {
	    	 pulse = productMethod();
	    	 inventoryFactory.pulseList.add(pulse);
	     }
	    
	    
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
	         System.out.println("The value of "+ (j+1)+" is "+ productValue);
	         
	     }
	     }
	     System.out.println("the total stock value is"+  totalValue);
	    
	 }
		
		
	
	
		public static ProductDetails productMethod() {
		ProductDetails productDetails = new ProductDetails();
	     System.out.println("Enter the product name");
	     String productName = Utility.userInputString();
	     productDetails.setProductName(productName);
	     System.out.println("Enter the product price");
	    long productPrice=Utility.userInputLong();
	     productDetails.setProductPrice(productPrice);
	     System.out.println("Enter the weight of the product");
	     long productWeight=Utility.userInputLong();
	     productDetails.setProductWeight(productWeight);
	     return productDetails;
	 }
	}
	
	

