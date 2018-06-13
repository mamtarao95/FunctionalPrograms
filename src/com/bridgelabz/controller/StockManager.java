/*******************************************************************************
 *  Purpose: This program provides StockManager as well as user interface functionalities 
 *
 *  @author  MamtaRao
 *  @version 1.0
 *  @since  13-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.bridgelabz.serviceimplementation.CustomerServiceImplementation;
import com.bridgelabz.serviceimplementation.StockServiceImplementation;
import com.bridgelabz.serviceimplementation.TransactionServiceImplementation;
import com.bridgelabz.utility.StockUtility;

public class StockManager<T extends Comparable<T>> {
	static CustomerServiceImplementation customerServiceImplementation = new CustomerServiceImplementation();

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		StockServiceImplementation stockServiceImplementation = new StockServiceImplementation();
		@SuppressWarnings("rawtypes")
		TransactionServiceImplementation transactionServiceImplementation = new TransactionServiceImplementation();

		System.out.println("WELCOME TO SHARE MARKET!!!");
		boolean keepOn = true;
		while (keepOn) {
			System.out.println("Enter your choice: ");
			System.out.println("(1)-COMPANY PORTFOLIO");
			System.out.println("(2)-CUSTOMER PORTFOLIO");
			System.out.println("(3)-BUY SHARE");
			System.out.println("(4)-PRINT REPORT");
			System.out.println("(5)-VIEW STOCKSYMBOL TRACK");
			System.out.println("(6)-VIEW DATE & TIME TRACK");
			System.out.println("(7)-QUIT STOCKMARKET");

			int choice1 = StockUtility.userInputInteger();
			switch (choice1) {

			case 1:
				System.out.println("Enter your choice");
				System.out.println("(1)-VIEW COMPANY LIST");
				System.out.println("(2)-ADD A COMPANY");
				System.out.println("(3)-DELETE A COMPANY");

				int choice2 = StockUtility.userInputInteger();
				switch (choice2) {
				case 1:
					transactionServiceImplementation.showStock();
					break;

				case 2:
					stockServiceImplementation.addStock();

					break;

				case 3:
					stockServiceImplementation.deleteStock();
					break;

				}
				break;
			case 2:
				System.out.println("Enter your choice");
				System.out.println("(1)-VIEW CUSTOMER");
				System.out.println("(2)-ADD A CUSTOMER");
				System.out.println("(3)-DELETE A CUSTOMER");
				System.out.println("(4)-UPDATE A CUSTOMER");

				int choice3 = StockUtility.userInputInteger();
				switch (choice3) {
				case 1:
					transactionServiceImplementation.showCustomers();
					break;

				case 2:
					customerServiceImplementation.addCustomer();
					break;

				case 3:
					customerServiceImplementation.deleteCustomer();
					break;
				case 4:
					transactionServiceImplementation.showCustomers();
					System.out.println("Enter the customerID");
					String customerID = StockUtility.userInputString();
					System.out.println("Enter new number of shares");
					int noOfShares = StockUtility.userInputInteger();
					System.out.println("Enter new price of shares");
					int priceOfShare = StockUtility.userInputInteger();
					customerServiceImplementation.updateCustomer(noOfShares, priceOfShare, customerID);
					break;
				}
				break;

			case 3:
				System.out.println("We have following shares available with us:");
				transactionServiceImplementation.showStock();
				System.out.println("Kindly enter stockSymbol you want to buy:");
				transactionServiceImplementation.buy(StockUtility.userInputString());
				break;

			case 4:
				transactionServiceImplementation.printReport();
				break;
			case 5:
				System.out.println("The list of Stock Symbol Purchased or Sold: ");
				transactionServiceImplementation.viewStockSymbolTrack();
				break;
			case 6:
				System.out.println("The record of date and time of trasaction: ");
				transactionServiceImplementation.viewDateTimeTrack();
				break;
			default:
				keepOn = false;
				System.out.println("Quitting StockMarket.ThankYou VisitAgain!!!");
			}

		}

	}
}
