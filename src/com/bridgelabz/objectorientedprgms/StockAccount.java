package com.bridgelabz.objectorientedprgms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bridgelabz.datastructureprograms.LinkedList;
import com.bridgelabz.util.Utility;

public class StockAccount {
	String fileName;
	double amount;
	int noOfShares;
 StockGetList stockgetlist = new  StockGetList();
 
	public StockAccount(String fileName) {
		this.fileName=fileName;
		amount=20000;
		noOfShares=5;
		System.out.println("New account created");
		stockgetlist.getStockListString().add("Reliance");
		stockgetlist.getStockListString().add("TATA");
		stockgetlist.getStockListString().add("BSNL");
		stockgetlist.getStockListString().add("PAYTM");
		stockgetlist.getStockListString().add("AIRTEL");
		
		System.out.println("The following shares are available with you:");
		for(int i=0; i<stockgetlist.getStockListString().size() ;i++ ) {
			System.out.println(stockgetlist.getStockListString().get(i));
		}
	}
	
	
	public double valueOf() {
		
		return amount;
		}
	
	public void buy(int amount,String symbol) {
		noOfShares--;
		this.amount+=amount;
		if(stockgetlist.getStockListString().contains(symbol)) {
			int index=stockgetlist.getStockListString().indexOf(symbol);
			String str=stockgetlist.getStockListString().remove(index);
			stockgetlist.getLinkedStack().push("Bought share "+ str);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			stockgetlist.getLinkedQueue().enQueue(str +" bought on "+ date.toString());
		}
		else {
			System.out.println("Company does'nt have the share that you are requesting for..!!");
		
		}
	}
	
	
	public void sell(int amount,String symbol) {
		
		noOfShares++;
		this.amount-=amount;
		if(stockgetlist.getStockListString().contains(symbol)) {
			int index=stockgetlist.getStockListString().indexOf(symbol);
			String str=stockgetlist.getStockListString().remove(index);
			stockgetlist.getLinkedStack().push(str);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			stockgetlist.getLinkedQueue().enQueue(date.toString());
		}
		else {
			System.out.println("Company does'nt have the share that you are requesting for..!!");
		
		}
		noOfShares++;
		this.amount-=amount;
		stockgetlist.getLinkedStock().push(symbol);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		stockgetlist.getLinkedQueue().enQueue(date.toString());
		}
	
	public void save(String fileNAme) {
		
		
	}
	
	public void printReport() {
		System.out.println("The number of shares hold by the company is "+noOfShares);
		System.out.println("the total amount of shares "+ amount);
		System.out.println("The following shares are available with you:");
		for(int i=0 ; i<linkedList.getCount();i++) {
			System.out.println(linkedList.getNth(i));
		}
		
		}
	
	
		
		
		
		
	}

}
