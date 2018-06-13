/*******************************************************************************
 *  Purpose: This program provides Stock POJO class 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since   13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.model;

public class Stock {
	private String stockSymbol;
	private int noOfShare;
	private double sharePrice;
	public Stock() {
	}

	public Stock(String stockSymbol, int noOfShare, double sharePrice) {
		this.stockSymbol = stockSymbol;
		this.noOfShare = noOfShare;
		this.sharePrice = sharePrice;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getNoOfShare() {
		return noOfShare;
	}

	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

}
