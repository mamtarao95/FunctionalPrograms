/*******************************************************************************
 *  Purpose: This class provides TransactionClass Service Implementation 
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.service.TransactionService;
import com.bridgelabz.utility.LinkedQueue;
import com.bridgelabz.utility.LinkedStack;
import com.bridgelabz.utility.StockUtility;

public class TransactionServiceImplementation<T extends Comparable<T>> implements TransactionService {
	File customerFileLoc = new File(
			"/home/administrator/mamta-workspace/StockMarket/src/com/bridgelabz/files/customer.json");
	LinkedList<Customer> customerList = new LinkedList<Customer>();
	static int index = 0;
	LinkedList<Stock> stockList = new LinkedList<Stock>();
	File stockFileLoc = new File("/home/administrator/mamta-workspace/StockMarket/src/com/bridgelabz/files/stock.json");
	ObjectMapper mapper = new ObjectMapper();
	LinkedList<Transaction> transactionList = new LinkedList<>();
	LinkedStack<String> stockSymbolTrack = new LinkedStack<String>();
	LinkedQueue<String> dateTimeTrack = new LinkedQueue<String>();
	File transactionFileLoc = new File(
			"/home/administrator/mamta-workspace/StockMarket/src/com/bridgelabz/files/TransactionReport.json");

	
	
	/**
	 * Method to view the list of customers
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void showCustomers() throws JsonParseException, JsonMappingException, IOException {
		customerList = StockUtility.parseJSONArray(customerFileLoc, Customer.class);
		for (Customer customer : customerList) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer));
		}

	}

	/**
	 * Method to view the list of stocks
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void showStock() throws JsonParseException, JsonMappingException, IOException {
		stockList = StockUtility.parseJSONArray(stockFileLoc, Stock.class);
		for (int i = 0; i < stockList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stockList.get(i)));
		}
	}

	/**
	 * Method to buy the stock from the list of available stock and updating the
	 * corresponding changes
	 * 
	 * @param stockSymbol
	 *            StockSymbol that is being purchased
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void buy(String stockSymbol) throws JsonParseException, JsonMappingException, IOException {
		stockList = StockUtility.parseJSONArray(stockFileLoc, Stock.class);
		customerList = StockUtility.parseJSONArray(customerFileLoc, Customer.class);
		transactionList = StockUtility.parseJSONArray(transactionFileLoc, Transaction.class);
		boolean found = false;

		// To find index of stockSymbol in the stock list
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getStockSymbol().equals(stockSymbol)) {
				index = i;
				found = true;
				break;
			}
		}

		// If stockSymbol is found and valid then allow customer to buy the stock
		if (found) {
			System.out.println("Enter number of shares you want to buy");
			int sharesBrought = StockUtility.userInputInteger();

			// Check if number of shares a customer willing to buy is available or not
			if (stockList.get(index).getNoOfShare() >= sharesBrought) {
				System.out.println("We have following customers available");
				showCustomers();
				System.out.println(".Please select customer by providing customerID");
				String customerID = StockUtility.userInputString();

				// To get the index of customer from customer list
				for (int i = 0; i < customerList.size(); i++) {
					if (customerList.get(i).getCustomerID().equals(customerID)) {
						Customer customerNew = customerList.get(i);
						double shareAmount = sharesBrought * (stockList.get(index).getSharePrice());
						double modifiedAmount = customerNew.getAmountOfShares() - shareAmount;

						if (modifiedAmount < 0) {
							System.out.println(
								"Sorry!! You don't have enough money to buy share.Kindly increase your capital");
							break;
						}

						// Update customer detail
						customerNew.setAmountOfShares(modifiedAmount);
						int modifiedNoOfShareOfCustomer = customerNew.getNoOfShares() + sharesBrought;
						customerNew.setNoOfShares(modifiedNoOfShareOfCustomer);
						customerNew.setCustomerID(customerID);
						customerNew.setCustomerName(customerNew.getCustomerName());
						customerList.remove(i);
						customerList.add(i, customerNew);
						mapper.writeValue(customerFileLoc, customerList);

						// Update Transaction detail
						Transaction transaction = new Transaction("BUY", customerNew.getCustomerName(), sharesBrought,
								stockSymbol, shareAmount, StockUtility.timeStamp());
						transactionList.add(transaction);
						mapper.writeValue(transactionFileLoc, transactionList);

						// Update Stock detail
						Stock stockNew = stockList.get(index);
						int modifiedNoOfShareOfCompany = stockNew.getNoOfShare() - sharesBrought;
						stockNew.setNoOfShare(modifiedNoOfShareOfCompany);
						stockNew.setSharePrice(stockNew.getSharePrice());
						stockNew.setStockSymbol(stockNew.getStockSymbol());
						stockList.remove(index);
						stockList.add(index, stockNew);
						mapper.writeValue(stockFileLoc, stockList);
						System.out.println("Shares bought successfully!!");
						break;
					}
					else {
						System.out.println("Sorry!! Customer doesn't exist.Kindly add customer and visit again!!");
					}
				}
			} else {
				System.out.println("Sorry!! Not enough shares. Better luck next time");
			}
		} else {
			System.out.println("Sorry!! Stock you are requesting for does not exist");
		}
	}

	/**
	 * Method to print transaction report
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void printReport() throws JsonParseException, JsonMappingException, IOException {
		transactionList = StockUtility.parseJSONArray(transactionFileLoc, Transaction.class);
		System.out.println("The transaction details are: ");
		for (int i = 0; i < transactionList.size(); i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(transactionList.get(i)));
		}

	}

	/**
	 * Method to view the details of stock symbol purchased and sold using stack
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void viewStockSymbolTrack() throws JsonParseException, JsonMappingException, IOException {
		transactionList = StockUtility.parseJSONArray(transactionFileLoc, Transaction.class);
		for (int i = 0; i < transactionList.size(); i++) {
			stockSymbolTrack.push(transactionList.get(i).getStockSymbol() + " -->TRANSACTIONTYPE--> "
					+ transactionList.get(i).getTransactionType());
		}
		stockSymbolTrack.display();
	}

	/**
	 * Method to view the date time details of purchased and sold symbols using
	 * queue
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void viewDateTimeTrack() throws JsonParseException, JsonMappingException, IOException {
		transactionList = StockUtility.parseJSONArray(transactionFileLoc, Transaction.class);
		for (int i = 0; i < transactionList.size(); i++) {
			dateTimeTrack.enQueue(transactionList.get(i).getTimeStamp() + " ---- "
					+ transactionList.get(i).getCustomerName() + " ---- " + transactionList.get(i).getStockSymbol());
		}
		dateTimeTrack.displayQueue();

	}

}
