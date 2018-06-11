package com.bridgelabz.model;

import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;

public class Doctor {
	private String doctorName;
	private String doctorID;
	private String doctorAvailability;
	private String doctorSpecialisation;
	private int countOfPatient=0;
	
	public Doctor(){}
	
	public Doctor(String doctorName,String doctorID,String doctorSpecialisation,String doctorAvailability) {
		this.doctorName=doctorName;
		this.doctorID=doctorID;
		this.doctorSpecialisation=doctorSpecialisation;
		this.doctorAvailability=doctorAvailability;
	}
	
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorAvailability() {
		return doctorAvailability;
	}
	public void setDoctorAvailability(String doctorAvailability) {
		this.doctorAvailability = doctorAvailability;
	}
	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}
	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}
	public int getCountOfPatient() {
		return countOfPatient;
	}
	public void setCountOfPatient(int countOfPatient) {
		this.countOfPatient = countOfPatient;
	}
	
	
	


}
