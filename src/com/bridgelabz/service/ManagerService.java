package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface ManagerService {
	
	public void addDoctor();
	
	public void addPatient();
	
	public void updatePatientAge(String patientName);
	
	public void updatePatientMobNumber(String patientName);
	
	public void deletePatient(String patientID);

	public void updateAvailTime(String doctorID) throws JsonParseException, JsonMappingException, IOException;

	public void updateSpecialisation(String doctorID) throws JsonParseException, JsonMappingException, IOException;
	
	public void deleteDoctor(String doctorID) throws JsonParseException, JsonMappingException, IOException;
}
