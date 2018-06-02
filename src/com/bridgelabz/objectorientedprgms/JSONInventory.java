package com.bridgelabz.objectorientedprgms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONInventory {
	public static void main(String[] args) {
			int priceOfRice=0;
		    int priceOfWheat=0;
		    int priceOfPulses=0;
		    int totalWeight=0;
		    
			JSONParser parser = new JSONParser();
			
			try {
				Object obj = parser.parse(new FileReader("/home/administrator/Documents/myjson.json"));
				JSONObject jsonObject = (JSONObject) obj;
		    
		            // Create JSONArray of rice
		            JSONArray rice = (JSONArray) jsonObject.get("Rice");
		            for(int i=0;i<rice.size();i++) {
		               JSONObject riceObj=(JSONObject) rice.get(i);
		               System.out.println(riceObj.toString());
		               priceOfRice+=(Integer.parseInt(riceObj.get("Price").toString()));
		               totalWeight+=(Integer.parseInt(riceObj.get("Weight").toString()));
		               }
		        System.out.println("Total price of rice is  "+priceOfRice+" for "+totalWeight+ " KG");
		        System.out.println("Total weight of rice is "+totalWeight);
		        System.out.println();
		          
		     // Create JSONArray of Pulses
	            JSONArray pulses = (JSONArray) jsonObject.get("Pulses");
	            for(int i=0;i<pulses.size();i++) {
	               JSONObject pulseObj=(JSONObject) pulses.get(i);
	               System.out.println(pulseObj.toString());
	               priceOfPulses+=(Integer.parseInt(pulseObj.get("Price").toString()));
	               totalWeight+=(Integer.parseInt(pulseObj.get("Weight").toString()));
	               }
	        System.out.println("Total price of pulses is  "+priceOfPulses+" for "+totalWeight+ " KG");
	        System.out.println("Total weight of pulses is "+totalWeight);
	        System.out.println();
	        
	        
	        
		     // Create JSONArray of Wheat
	           JSONArray wheat = (JSONArray) jsonObject.get("Wheats");
	           for(int i=0;i<wheat.size();i++) {
	              JSONObject wheatObj=(JSONObject) wheat.get(i);
	              System.out.println(wheatObj.toString());
	              priceOfWheat+=(Integer.parseInt(wheatObj.get("Price").toString()));
	              totalWeight+=(Integer.parseInt(wheatObj.get("Weight").toString()));
	              }
	       System.out.println("Total price of Wheat is  "+priceOfWheat+" for "+totalWeight+ " KG");
	       System.out.println("Total weight of Wheat is "+totalWeight);
	       System.out.println();
			
			}

			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		}

	}

