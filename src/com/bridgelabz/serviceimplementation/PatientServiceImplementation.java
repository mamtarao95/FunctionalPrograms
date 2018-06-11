package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelbaz.utility.ClinicUtility;

public class PatientServiceImplementation {
	String doctorFileLoc = "/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Doctor.json";
	String patientFileLoc = "/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Patient.json";
	String appointmentFile = "/home/administrator/mamta-workspace/ClinicManagement/src/com/bridgelabz/files/Appointment.json";
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	ArrayList<Patient> foundpatientList = new ArrayList<Patient>();
	public ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Doctor> fixedDoctor = new ArrayList<Doctor>();
	Doctor doctor = new Doctor();
	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	ObjectMapper mapper = new ObjectMapper();
	Patient patient = new Patient();
	Appointment appointment = new Appointment();

	/**
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void showPatient() throws JsonParseException, JsonMappingException, IOException {
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);
		for (int i = 0; i < patientList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((patientList.get(i))));
		}

	}

	/**
	 * @param Name
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientByName(String Name) throws JsonGenerationException, JsonMappingException, IOException {
		String patientName = Name.replaceAll(" ", "");
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);
		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().replaceAll(" ", "").equals(patientName)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	/**
	 * @param ID
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientByID(String ID) throws JsonGenerationException, JsonMappingException, IOException {
		String patientID = ID.replaceAll(" ", "");
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);

		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientID().replaceAll(" ", "").equals(patientID)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	/**
	 * @param MobNumber
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void searchPatientMobNumber(String MobNumber)
			throws JsonGenerationException, JsonMappingException, IOException {

		String patientMobNumber = MobNumber.replaceAll(" ", "");
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);

		boolean found = false;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientMobNumber().replaceAll(" ", "").equals(patientMobNumber)) {
				// take appointment method
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			for (int i = 0; i < foundpatientList.size(); i++) {
				System.out
						.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundpatientList.get(i))));
			}
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	public void updatePatientAge(String patientName) throws JsonParseException, JsonMappingException, IOException {
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(patientName)) {
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			System.out.println("Enter patient's new age: ");
			int patientNewAge = ClinicUtility.userInputInteger();
			for (int i = 0; i < foundpatientList.size(); i++) {
				foundpatientList.get(i).setPatientAge(patientNewAge);
			}
			System.out.println("Successfully updated!!");
			mapper.writeValue((file), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	public void updatePatientMobNumber(String patientName)
			throws JsonParseException, JsonMappingException, IOException {
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(patientName)) {
				foundpatientList.add(patientList.get(i));
				found = true;
			}
		}

		if (found) {
			System.out.println("Enter patient's new mobile number: ");
			String patientNewMobNumber = ClinicUtility.userInputString();
			for (int i = 0; i < foundpatientList.size(); i++) {
				foundpatientList.get(i).setPatientMobNumber(patientNewMobNumber);
			}
			System.out.println("Successfully updated!!");
			mapper.writeValue((file), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}

	}

	public void deletePatient(String patientID) throws JsonParseException, JsonMappingException, IOException {
		File file = new File(patientFileLoc);
		patientList = ClinicUtility.parseJSONArray(file, Patient.class);

		boolean found = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientID().equals(patientID)) {
				patientList.remove(i);
				found = true;
			}
		}

		if (found) {
			System.out.println("Successfully deleted!!");
			mapper.writeValue((file), patientList);
		} else {
			System.out.println("Sorry!! The patient you are searching for is not found in our record!!");
		}
	}

	static int index = 0;
	public void takeAppointment(ArrayList<Doctor>foundDoctorList,String patientDetails1,String patientDetails2) throws JsonGenerationException, JsonMappingException, IOException {
	ArrayList<Doctor> fixedDoctor = new ArrayList<Doctor>();
	System.out.println("Kindly provide the doctor's ID to fix your choice");
	String fixDoctor=ClinicUtility.userInputString();
	appointmentList=ClinicUtility.parseJSONArray(new File(appointmentFile),Appointment.class);
		
	
	
		for(int i=0 ;i<foundDoctorList.size();i++) {
		if(foundDoctorList.get(i).getDoctorID().equals(fixDoctor)) {
				fixedDoctor.add(foundDoctorList.get(i));
				foundDoctorList.remove(foundDoctorList.get(i));
				}
		}
		
		
		doctorList=ClinicUtility.parseJSONArray(new File(doctorFileLoc), Doctor.class);
		System.out.println("yrueee");
		int count=fixedDoctor.get(0).getCountOfPatient();
		if(count<5) {
		fixedDoctor.get(0).setCountOfPatient(count+1);
			
		for(int j=0 ;j<doctorList.size();j++) {
					if(doctorList.get(j).getDoctorID().equals(fixDoctor)) {
							 index=j;
							 break;
				}}
					
	
			doctorList.add(index,fixedDoctor.get(0));
			doctorList.remove(index+1);
			mapper.writeValue(new File(doctorFileLoc),doctorList);
					
			appointment.setPatientName(patientDetails1);
			appointment.setPatientID(patientDetails2);
			appointment.setDoctorID(fixDoctor);
			appointment.setDoctorName(fixedDoctor.get(0).getDoctorName());
			appointment.setTimeStamp(appointment.getTimeStamp());
			appointmentList.add(appointment);
			mapper.writeValue((new File(appointmentFile)),appointmentList);
			System.out.println("Your appointment has been fixed");
		}
		
		else {
			System.out.println("Doctor's intake of patient is filled..!! Kindly look for someother doctors!!");
			System.out.println("The other doctors available as per your requirement:");
			if(!foundDoctorList.isEmpty()) {
				for(int z=0;z<foundDoctorList.size();z++) {
					System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((foundDoctorList.get(z))));
				}
			System.out.println("You may continue with your appointment");
			
			takeAppointment(foundDoctorList, patientDetails1,patientDetails2);
			}
			else {
				System.out.println("No doctors available");
			}
		}
	}
	
	public void popularDoctor() throws JsonParseException, JsonMappingException, IOException {
		doctorList=ClinicUtility.parseJSONArray(new File(doctorFileLoc), Doctor.class);
		int[] countArray=new int[doctorList.size()];
		for(int i=0 ;i<doctorList.size();i++) {
			countArray[i]=doctorList.get(i).getCountOfPatient();
		}
		
		
		
		
		
		
	}
}
			
		
