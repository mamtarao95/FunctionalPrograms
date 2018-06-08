package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SampleJSON {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, ParseException {
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<Object> arrayList =new ArrayList<Object>();
		ArrayList<Person> arrayList1 =new ArrayList<Person>();
		
		File file =new File("/home/administrator/mamta-workspace/Basicjavaprograms/friends.json");
		JSONParser parser1 = new JSONParser();
		Object obj1 = parser1.parse(new FileReader(file));
		JSONArray array1 = (JSONArray) obj1;
		for (int i = 0; i < array1.size(); i++) {
			arrayList.add(array1.get(i));
		}
		System.out.println(arrayList.toString());
		
		arrayList1 = mapper.readValue((file), new TypeReference<ArrayList<Person>>() {});
		System.out.println(arrayList1.toString());
		
	}

}
