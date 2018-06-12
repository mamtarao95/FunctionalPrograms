package com.bridgelbaz.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


public class ClinicUtility {
	static ObjectMapper mapper=new ObjectMapper();
	
	static Scanner scanner=new Scanner(System.in);

	/*
	 * Method to take user input as string
	 */
	public static String userInputString() {
		return scanner.next();

	}

	/*
	 * Method to take user input as long
	 */
	public static Long userInputLong() {
		return scanner.nextLong();

	}

	public static String userInputStringLine() {
		return scanner.nextLine();
	}

	/*
	 * Method to take user input as integer
	 */
	public static int userInputInteger() {
		return scanner.nextInt();
	}

	/*
	 * Method to take user input as double
	 */
	public static Double userInputDouble() {
		return scanner.nextDouble();
	}

	/*
	 * Method to take user input as boolean
	 */
	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}
	
	
	public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<T> arrayList = new ArrayList<T>();
		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class,clazz);
		arrayList = mapper.readValue(file, javaType);
		
	
		return arrayList;

	}
	
	public static String[] takeDoctorInputs() {
		System.out.println("Kindly enter the doctor's details: ");
		System.out.println("Enter doctor's name: ");
		ClinicUtility.userInputStringLine();
		String doctorName=ClinicUtility.userInputStringLine();
		System.out.println("Enter doctor's ID: ");
		String doctorID=ClinicUtility.userInputString();
		System.out.println("Enter doctor's specialisation: ");
		ClinicUtility.userInputStringLine();
		String doctorSpecialisation=ClinicUtility.userInputStringLine();
		System.out.println("Enter doctor's availability slot(AM/PM/Both): ");
		String doctorAvailability=ClinicUtility.userInputString();
		String doctorsDetails[]= {doctorName,doctorID,doctorSpecialisation,doctorAvailability};
		return doctorsDetails;
	}
	
	public static String[] takePatientInputs() {
		System.out.println("Kindly enter the patient's details: ");
		System.out.println("Enter patient's name: ");
		ClinicUtility.userInputStringLine();
		String patientName=ClinicUtility.userInputStringLine();
		System.out.println("Enter patient's ID: ");
		String patientID=ClinicUtility.userInputString();
		System.out.println("Enter patients's mobile number: ");
		ClinicUtility.userInputStringLine();
		String patientMobileNumber=ClinicUtility.userInputStringLine();
		System.out.println("Enter patient's age ");
		int patientAge=ClinicUtility.userInputInteger();
		String doctorsDetails[]= {patientName,patientID,patientMobileNumber,Integer.toString(patientAge)};
		return doctorsDetails;
	}
	public static String timeStamp() {
		Date date = new Date();  
	    Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		return (formatter.format(ts));
	}
}
