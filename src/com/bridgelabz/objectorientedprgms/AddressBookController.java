package com.bridgelabz.objectorientedprgms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
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

public class AddressBookController  {
	
	AddressBook addressBook=new AddressBook(); 
	LinkedList<String> addressBookList = new LinkedList<String>();
	ArrayList<Object>arrayList = new ArrayList<Object>();
	
	
/*
	public AddressBookController() throws JsonGenerationException, JsonMappingException, IOException {
		new AddressBook(); 
	}*/
	
	public void doAdd(String firstName,String lastName,String address,String city,String state,String zip,String phone) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
	     Object obj = parser.parse(new FileReader("/home/administrator/mamta-workspace/Basicjavaprograms/first"));
	     JSONArray array = (JSONArray) obj;
	  
	     	for(int i=0 ; i< array.size();i++) {
	     		arrayList.add(array.get(i));
	     	}
	       
	
		/*int book=addressBookList.indexOf(file);
		String selectedFile=addressBookList.get(book);*/
		String template="/home/administrator/mamta-workspace/Basicjavaprograms/first";
		File file=new File(template);
		addressBook.addPerson(firstName,lastName, address, city, state, zip, phone,file,arrayList);
		}
	
	public void doEdit(int index) {
		System.out.println("Enter the address");
		String address=Utility.userInputString();
		
		System.out.println("Enter the new city");
		String city=Utility.userInputString();
		
		System.out.println("Enter the new state");
		String state=Utility.userInputString();
		System.out.println("Enter the new zip");
		String zip=Utility.userInputString();
		System.out.println("Enter the new phone");
		String phone=Utility.userInputString();
		
		addressBook.updatePerson(index, address, city, state, zip, phone);
		
	}
	
	public void doDelete(int index) {
		addressBook.removePerson(index);
	}
	
	public void doSortByName() {
		addressBook.sortByName();
	}

	public void doSortByZip() {
		addressBook.sortByZip();
	}
	
	public void doPrint() {
		addressBook.printAll();
	}
	
	public void doNew() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		String template="/home/administrator/mamta-workspace/Basicjavaprograms/";
		System.out.println("Enter the name of new address book ");
		String addressBookName=Utility.userInputString();
		ObjectMapper mapper=new ObjectMapper();
		File file=new File(template+addressBookName+".json");
		mapper.writeValue(file,addressBook.personList);
		
		/*addressBookList.add(file);
		File pathAddress=new File("/home/administrator/mamta-workspace/Basicjavaprograms/addressBooks");
		mapper.writeValue((pathAddress),addressBookList);*/
		
	  }

	
	public void doOpen() throws java.io.IOException, java.lang.ClassCastException,java.lang.ClassNotFoundException,java.lang.InterruptedException,java.lang.SecurityException, ParseException{
		System.out.println("Enter the name of address book you want to open");
		String addressBookNameOpen=Utility.userInputString();
		File fileOpen=new File("/home/administrator/mamta-workspace/Basicjavaprograms/"+addressBookNameOpen);
		JSONParser parser = new JSONParser();
	     Object obj = parser.parse(new FileReader(fileOpen));
	     JSONObject jsonObject = (JSONObject) obj;
	     System.out.println(jsonObject);
	}

	public void doSave()throws java.io.IOException, java.lang.InterruptedException,java.lang.SecurityException{
		
	}


}
