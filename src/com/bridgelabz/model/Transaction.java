/*******************************************************************************
 *  Purpose: This program provides Transaction POJO class 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.model;

public class Transaction {
	private String transactionType;
	private String customerName;
	private int sharesBrought;
	private String stockSymbol;
	private double shareAmount;
	private String timeStamp;

	public Transaction() {
	}

	public Transaction(String transactionType, String customerName, int sharesBrought, String stockSymbol,
			double shareAmount, String timeStamp) {

		this.transactionType = transactionType;
		this.customerName = customerName;
		this.sharesBrought = sharesBrought;
		this.stockSymbol = stockSymbol;
		this.shareAmount = shareAmount;
		this.timeStamp = timeStamp;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getSharesBrought() {
		return sharesBrought;
	}

	public void setSharesBrought(int sharesBrought) {
		this.sharesBrought = sharesBrought;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getShareAmount() {
		return shareAmount;
	}

	public void setShareAmount(double shareAmount) {
		this.shareAmount = shareAmount;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
