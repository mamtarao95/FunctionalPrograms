/******************************************************************************
 *  Purpose:Program for inventory factory that allows to access the storage list
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.util.ArrayList;

public class InventoryFactory {
	ArrayList<ProductDetails> riceList = new ArrayList<ProductDetails>();
	ArrayList<ProductDetails> wheatList = new ArrayList<ProductDetails>();
	ArrayList<ProductDetails> pulseList = new ArrayList<ProductDetails>();
	public ArrayList<ProductDetails> getRiceList() {
		return riceList;
	}
	public void setRiceList(ArrayList<ProductDetails> riceList) {
		this.riceList = riceList;
	}
	public ArrayList<ProductDetails> getWheatList() {
		return wheatList;
	}
	public void setWheatList(ArrayList<ProductDetails> wheatList) {
		this.wheatList = wheatList;
	}
	public ArrayList<ProductDetails> getPulseList() {
		return pulseList;
	}
	public void setPulseList(ArrayList<ProductDetails> pulseList) {
		this.pulseList = pulseList;
	}
	

}
