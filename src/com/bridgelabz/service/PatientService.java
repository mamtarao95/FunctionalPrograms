package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface PatientService {
	
	public  void showPatient() throws JsonParseException, JsonMappingException, IOException;

	public void searchPatientByName(String patientName) throws JsonGenerationException, JsonMappingException, IOException;

	public void searchPatientByID(String patientID) throws JsonParseException, JsonMappingException, IOException;

	public void searchPatientMobNumber(String patientMobNumber) throws JsonParseException, JsonMappingException, IOException;

	public void takeAppointment();
}
