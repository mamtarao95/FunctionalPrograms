package com.bridgelabz.model;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat; 
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
		Date date = new Date();  
	    Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		return (formatter.format(ts));
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp= timeStamp;
		}
	

}
