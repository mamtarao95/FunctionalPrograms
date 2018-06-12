package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface DoctorService {

public  void showDoctors() throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsByName(String doctorName,String patientDetails1,String patientDetails2) throws JsonGenerationException, JsonMappingException, IOException, NoSuchMethodException, SecurityException, ClassNotFoundException;

	public void searchDoctorsByID(String doctorID,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsBySpecialisation(String specialisation,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;

	public void searchDoctorsByAvailability(String availability,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException;

	
}
