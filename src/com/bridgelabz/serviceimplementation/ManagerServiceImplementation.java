package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelbaz.utility.ClinicUtility;

public class ManagerServiceImplementation {
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Patient> patientList=new ArrayList<>();
	ObjectMapper mapper=new ObjectMapper();
	String doctorFileLoc = "/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Doctor.json";
	String patientFileLoc="/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Patient.json";
	
	
	public void addDoctor(String doctorName,String doctorID,String doctorSpecialisation,String doctorAvailability) throws JsonMappingException, IOException {
	File file=new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		Doctor doctor=new Doctor( doctorName, doctorID, doctorSpecialisation, doctorAvailability);
		doctorList.add(doctor);
		for(int i=0 ;i<doctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((doctorList.get(i))));
		}
		
		mapper.writeValue((file), doctorList);
		System.out.println("Doctor added successfully!!");
	}
	
	public void updateDoctor() {
		
		
	}
	
	public void deleteDoctor() {
		
	}
	
	public void addPatient(String patientName,String patientID,String patientMobNumber,int patientAge) throws JsonParseException, JsonMappingException, IOException {
		File file=new File( patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);
		Patient patient=new Patient(patientName,patientID,patientMobNumber, patientAge);
	
		patientList.add(patient);
		for(int i=0 ;i<patientList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((patientList.get(i))));
		}
		
		mapper.writeValue((file), patientList);
		
	}
	
	public void updatePatient() {
		
	}
	
	public void deletePatient() {
		
	}

}
