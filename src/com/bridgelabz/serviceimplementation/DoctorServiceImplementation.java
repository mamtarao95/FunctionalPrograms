package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.DoctorService;
import com.bridgelbaz.utility.ClinicUtility;
import java.lang.reflect.*;

public class DoctorServiceImplementation implements DoctorService {
	 
	ObjectMapper mapper = new ObjectMapper();
	public ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Doctor> foundDoctorList = new ArrayList<Doctor>();
	Doctor doctor = new Doctor();
	String doctorFileLoc = "/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Doctor.json";
PatientServiceImplementation patientServiceImplementation=new PatientServiceImplementation();
	
	
	public void showDoctors() throws JsonParseException, JsonMappingException, IOException {
		File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		for (int i = 0; i < doctorList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((doctorList.get(i))));
		}
	}

	
	/**
	 * @param doctorName
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public void searchDoctorsByName(String Name,String patientDetails1,String patientDetails2) throws JsonGenerationException, JsonMappingException, IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		String doctorName=Name.replaceAll(" ","");
		File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		
		/*Class<? extends Doctor> cls=doctor.getClass();
		
		Method methodcall= Class.forName("com.bridgelabz.model.Doctor").getMethod("getDoctorName",String.class);*/
	
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorName().replaceAll(" ","").equals(doctorName)) {
				//take appointment method
				foundDoctorList.add(doctorList.get(i));
			
				found=true;
			}
		}
		
		if(found) {
			for(int i=0 ; i<foundDoctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(i))));
			patientServiceImplementation.takeAppointment(foundDoctorList,patientDetails1,patientDetails2);
			

			
			}
		}else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
		}
}

	
	public void searchDoctorsByID(String ID) throws JsonParseException, JsonMappingException, IOException {
		File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorID().equals(ID)) {
				//take appointment method
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
		
		if(found) {
			for(int i=0 ; i<foundDoctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(i))));
			}
		}else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
		}
	}

	public void searchDoctorsBySpecialisation(String specialisation,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException {
		File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorSpecialisation().equals(specialisation)) {
				//take appointment method
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
		
		if(found) {
			for(int i=0 ; i<foundDoctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(i))));
			}
			patientServiceImplementation.takeAppointment(foundDoctorList,patientDetails1,patientDetails2);
		}else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
		}
	}
	

	public void searchDoctorsByAvailability(String availability,String patientDetails1,String patientDetails2) throws JsonParseException, JsonMappingException, IOException {
		File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorAvailability().equals(availability)) {
				//take appointment method
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
		
		if(found) {
			for(int i=0 ; i<foundDoctorList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(i))));
			}
			
			patientServiceImplementation.takeAppointment(foundDoctorList,patientDetails1,patientDetails2);
		}else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
		}
	}
	
 public void updateAvailTime(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorID().equals(doctorID)) {
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
	
		if (found) {
			System.out.println("Enter new availiability time: ");
			String newAvailTime=ClinicUtility.userInputString() ;
			for(int i = 0; i < foundDoctorList.size(); i++) {
				foundDoctorList.get(i).setDoctorAvailability(newAvailTime);
				}
			System.out.println("Successfully updated!!");
			mapper.writeValue((file),doctorList);
			
			
			} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
			}
 
	}
	
 
 
 public void updateSpecialisation(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 File file = new File(doctorFileLoc);
		doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);
		boolean found=false;
		for(int i=0 ; i<doctorList.size();i++) {
			if(doctorList.get(i).getDoctorID().equals(doctorID)) {
				foundDoctorList.add(doctorList.get(i));
				found=true;
			}
		}
	
		if (found) {
			System.out.println("Enter new specialisation: ");
			String newSpecialisation=ClinicUtility.userInputString() ;
			for(int i = 0; i < foundDoctorList.size(); i++) {
				foundDoctorList.get(i).setDoctorSpecialisation(newSpecialisation);
				}
			System.out.println("Successfully updated!!");
			mapper.writeValue((file),doctorList);
			} else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
			}
	 
	}
 
 public void deleteDoctor(String doctorID) throws JsonParseException, JsonMappingException, IOException {
	 File file = new File(doctorFileLoc);
	  doctorList = ClinicUtility.parseJSONArray(file, Doctor.class);

		boolean found = false;
		for (int i = 0; i <  doctorList.size(); i++) {
			if ( doctorList.get(i).getDoctorID().equals(doctorID)) {
				 doctorList.remove(i);
				found = true;
			}
		}
	
		if (found) {
			System.out.println("Successfully deleted!!");
			mapper.writeValue((file), doctorList);
			} else {
			System.out.println("Sorry!! The doctor you are searching for is not found in our record!!");
			}
		
	}




	 
	 
	 
	 
	 
	 
	 
 }
 
 

