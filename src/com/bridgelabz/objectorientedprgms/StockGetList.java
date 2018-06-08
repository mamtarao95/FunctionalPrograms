/******************************************************************************
 *  Purpose:Program provides arrayList implementation for stock management
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.objectorientedprgms;

import java.util.ArrayList;

public class StockGetList {
	    ArrayList<Stock> stockList = new ArrayList<Stock>();

	    public ArrayList<Stock> getStockList() {
	        return stockList;
	    }

	    public void setStock(ArrayList<Stock> stockList) {
	        this.stockList = stockList;
	    }
	     
	}


