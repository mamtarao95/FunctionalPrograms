package com.bridgelabz.model;

public class Appointment {
	private String doctorName;
	private String doctorID;
	private String patientName;
	private String patientID;
	private String timeStamp;
	
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getTimeStamp() {
		
		return timeStamp;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp= timeStamp;
		}
	

}
