package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface ManagerService {
	
	public void addDoctor(String doctorName,String doctorID,String doctorSpecialisation,String doctorAvailability) throws JsonMappingException, IOException;
	
	public void addPatient(String patientName,String patientID,String patientMobNumber,int patientAge) throws JsonParseException, JsonMappingException, IOException;
	
	public void updatePatientAge(String patientName) throws JsonParseException, JsonMappingException, IOException;
	
	public void updatePatientMobNumber(String patientName) throws JsonParseException, JsonMappingException, IOException;
	
	public void deletePatient(String patientID) throws JsonParseException, JsonMappingException, IOException;

	public void updateAvailTime(String doctorID) throws JsonParseException, JsonMappingException, IOException;

	public void updateSpecialisation(String doctorID) throws JsonParseException, JsonMappingException, IOException;
	
	public void deleteDoctor(String doctorID) throws JsonParseException, JsonMappingException, IOException;
}
