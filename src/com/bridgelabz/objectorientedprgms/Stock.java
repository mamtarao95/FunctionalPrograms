/******************************************************************************
 *  Purpose:POJO Class for StockDetails 
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

public class Stock  {
	private String stockName;
	private long noOfShare;
	private long sharePrice;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(long noOfShare) {
		this.noOfShare = noOfShare;
	}
	public long getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	

}
