/*******************************************************************************
 *  Purpose: This program provides Customer POJO class 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.model;

public class Customer {
	private String customerName;
	private String customerID;
	private int noOfShares;
	private double amountOfShares;
	
	public Customer() {}
	public Customer(String customerName,int noOfShares,double amountOfShares,String customerID) {
		this.customerName=customerName;
		this.noOfShares=noOfShares;
		this.amountOfShares=amountOfShares;
		this.customerID=customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public double getAmountOfShares() {
		return amountOfShares;
	}
	public void setAmountOfShares(double amountOfShares) {
		this.amountOfShares = amountOfShares;
	}
	
	
	

}
