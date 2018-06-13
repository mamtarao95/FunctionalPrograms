/*******************************************************************************
 *  Purpose: This class provides StockClass Service Implementation 
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
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.utility.StockUtility;

public class StockServiceImplementation implements StockService {
	LinkedList<Stock> stockList = new LinkedList<Stock>();
	File stockFileLoc = new File("/home/administrator/mamta-workspace/StockMarket/src/com/bridgelabz/files/stock.json");
	ObjectMapper mapper = new ObjectMapper();
	TransactionServiceImplementation transactionServiceImplementation = new TransactionServiceImplementation<>();

	/**
	 * Method to add stock to stock list
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addStock() throws JsonGenerationException, JsonMappingException, IOException {
		String stockDetails[] = StockUtility.takeStockInputs();
		Stock stock = new Stock(stockDetails[0], Integer.parseInt(stockDetails[1]),
				Double.parseDouble(stockDetails[2]));
		stockList = StockUtility.parseJSONArray(stockFileLoc, Stock.class);
		stockList.add(stock);
		mapper.writeValue(stockFileLoc, stockList);
		System.out.println("Stock addedd successfully");
	}

	/**
	 * Method to delete stock
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void deleteStock() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("The stock list is: ");
		transactionServiceImplementation.showStock();
		System.out.println("Enter the stockSymbol you wish to delete");
		String stockSymbol = StockUtility.userInputString();
		stockList = StockUtility.parseJSONArray(stockFileLoc, Stock.class);
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getStockSymbol().equals(stockSymbol)) {
				stockList.remove(stockList.get(i));
				break;
			}
		}
		mapper.writeValue(stockFileLoc, stockList);
		System.out.println("Deleted stock successfully");
	}

}
