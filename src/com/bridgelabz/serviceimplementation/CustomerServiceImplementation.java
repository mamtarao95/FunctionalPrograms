/*******************************************************************************
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
import com.bridgelabz.service.CustomerService;
import com.bridgelabz.utility.StockUtility;

public class CustomerServiceImplementation implements CustomerService {
TransactionServiceImplementation transactionServiceImplementation = new TransactionServiceImplementation();
	File customerFileLoc = new File(
			"/home/administrator/mamta-workspace/StockMarket/src/com/bridgelabz/files/customer.json");
	LinkedList<Customer> customerList = new LinkedList<Customer>();
	ObjectMapper mapper = new ObjectMapper();
	Customer customer = new Customer();

	/**
	 * Method to add customer to the customer list
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addCustomer() throws JsonParseException, JsonMappingException, IOException {
		String customerDetails[] = StockUtility.takeCustomerInputs();
		Customer customer = new Customer(customerDetails[0], Integer.parseInt(customerDetails[1]),
				Double.parseDouble(customerDetails[2]), (customerDetails[3]));
		customerList = StockUtility.parseJSONArray(customerFileLoc, Customer.class);
		customerList.add(customer);
		mapper.writeValue(customerFileLoc, customerList);
		System.out.println("Customer added successfully");

	}

	/**
	 * Method to delete customer to the customer list
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void deleteCustomer() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("The customer list is: ");
		transactionServiceImplementation.showCustomers();
		System.out.println("Enter the customerID");
		String customerID = StockUtility.userInputString();
		customerList = StockUtility.parseJSONArray(customerFileLoc, Customer.class);
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getCustomerID().equals(customerID)) {
				customerList.remove(customerList.get(i));
				break;
			}
		}
		mapper.writeValue(customerFileLoc, customerList);
		System.out.println("Customer deleted successfully");

	}

	/**
	 * Method to update customer
	 * @param noOfShares
	 * @param amountOfShares
	 * @param customerID
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updateCustomer(int noOfShares, int amountOfShares, String customerID)
			throws JsonParseException, JsonMappingException, IOException {
		int index = 0;
		customerList = StockUtility.parseJSONArray(customerFileLoc, Customer.class);
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getCustomerID().equals(customerID)) {
				index = i;
				customer = customerList.get(i);
				customer.setCustomerName(customer.getCustomerName());
				customer.setNoOfShares(noOfShares);
				customer.setAmountOfShares(amountOfShares);
				customer.setCustomerID(customer.getCustomerID());
				break;
			}
		}
		customerList.remove(index);
		customerList.add(index, customer);
		mapper.writeValue(customerFileLoc, customerList);
		System.out.println("Customer updated successfully!!");
	}
}
