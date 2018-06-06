package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBook {
ArrayList<Person> personList = new ArrayList<Person>();
Person.CompareByName compareByName=new Person.CompareByName();
Person.CompareByZip compareByZip=new Person.CompareByZip();
Person person=new Person();
ObjectMapper mapper=new ObjectMapper();
public AddressBook() {
	
	
}

public AddressBook(String file) throws JsonGenerationException, JsonMappingException, IOException {
	
	//mapper.writeValue((file),personList);
}

public void addPerson(String firstName,String lastName,String address,String city,String state,String zip,String phone,File file,ArrayList arrayList) throws JsonGenerationException, JsonMappingException, IOException, ParseException{
	//ArrayList<Object> personList= new ArrayList<Object>();
	/*JSONParser parser = new JSONParser();
    Object obj = parser.parse(new FileReader(file));
    JSONObject jsonObject = (JSONObject) obj;
    JSONArray array = (JSONArray) jsonObject.get(jsonObject);
    Set<String> keys=jsonObject.keySet();
    for (String values : keys) {
    	JSONArray personArray=(JSONArray)jsonObject.get(values);
    	
    	for(int i=0 ; i< personArray.size();i++) {
    		personList.add(personArray.get(i));
    	}*/
   
    Person person= new Person(firstName,lastName,address,city,state,zip,phone);
	arrayList.add(person);
	mapper.writeValue((file),arrayList);
    }
	
	

public String getFullNameOfPerson(int index) {
	return personList.get(index).getFirstName()+personList.get(index).getLastName();
	}

public int getNumberOfPersons() {
	return personList.size();
}

public String[] getOtherPersonInformation(int index) {
	Person person=personList.get(index);
	String[] otherInformation= {person.getAddress(),person.getCity(),person.getZip(),person.getState(),person.getPhone()};
	return otherInformation;
}

public void updatePerson(int index,String address,String city,String state,String zip,String phone) {
	Person person=personList.get(index);
	person.update(address, city, state, zip, phone);
	
}

public void removePerson(int index) {
	personList.remove(index);
}


public void sortByName() {
	for(int index=0 ; index<personList.size() ; index++) {
		compareByName.compare(personList.get(index), personList.get(index+1));
	}
	
}

public void sortByZip() {
		for(int index=0 ; index<personList.size() ; index++) {
			compareByZip.compare(personList.get(index),personList.get(index+1));
		}
		
	}
		
public void printAll() {
	personList.toString();
}

public String toString() {
    
   return "FirstName: "+person.getFirstName()+"; LastName: "+person.getLastName()+"; Address: "+ person.getAddress()+"; City: "+person.getCity()+"; ZipCode: "+person.getZip()+"; State: "+person.getState()+"; PhoneNumber: "+person.getPhone();  
}











}




	

