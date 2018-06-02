package com.bridgelabz.objectorientedprgms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockPortfolio {
	
	public static void main(String[] args) {
JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("/home/administrator/Documents/stockjson.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			//create stock1
			JSONObject stock1=(JSONObject) jsonObject.get("Stock1");
			String shareName = (String) stock1.get("ShareName");
			System.out.println("ShareName: " + shareName);
		
			 /*Iterator<String> iterator = stock1.iterator();
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next());
	            }
			*/
			
			
		
	
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
