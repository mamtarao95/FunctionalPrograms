package com.bridgelabz.objectorientedprgms;

import com.bridgelabz.datastructureprograms.LinkedList;
import com.bridgelabz.util.Utility;

public class StockAccount {
	String fileName;
	double amount;
	int noOfShares;
	static LinkedList<String> linkedList=new LinkedList<String>();

	public StockAccount(String fileName) {
		this.fileName=fileName;
		amount=20000;
		noOfShares=5;
		System.out.println("New file created");
		linkedList.add("ABC");
		linkedList.add("XYZ");
		linkedList.add("NPR");
		linkedList.add("WTN");
		linkedList.add("ITU");
		
		System.out.println("The following shares are available with you:");
		for(int i=0 ; i<linkedList.getCount();i++) {
			System.out.println(linkedList.getNth(i));
		}
		}
	
	public double valueOf() {
		return amount;
		}
	
	public void buy(int amount,String symbol) {
		
		noOfShares++;
		this.amount+=amount;
		linkedList.add(symbol);
		}
	
	public void sell(int amount,String symbol) {
		noOfShares--;
		this.amount-=amount;
		linkedList.remove(symbol);
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
	
	public static void main(String[] args) {
		System.out.println("Want to create a new account??");
		System.out.println("Enter the file name");
		String fileName=Utility.userInputString();
		StockAccount stockAccount=new StockAccount(fileName);
		System.out.println("the current amount is "+ stockAccount.amount);
		System.out.println("the current number of shares is "+ stockAccount.noOfShares);
		boolean keepGoing=true;
		
	 while(keepGoing) {
		
		System.out.println("Enter your choice: (1)-SELL THE SHARES    (2)-BUY THE SHARES  (3)-PRINT REPORT");
		switch(Utility.userInputInteger()) {
		case 1: 
			System.out.println("Enter the name of the share you want to sell ");
			String name1=Utility.userInputString();
			if(linkedList.search(name1)) {
				System.out.println("Enter the amount in which you want to sell you share ");
				int sellingAmount=Utility.userInputInteger();
				if(sellingAmount>stockAccount.amount) {
					System.out.println("You dont have enough money to sell your share");
				}
				else {
				stockAccount.sell(sellingAmount,name1);
				}
			}
			else {
				System.out.println("You dont have the share named "+ name1+" in your account");
			}
			
			break;
	
		
		case 2:
			System.out.println("Enter the name of the share you want to buy ");
			String name2=Utility.userInputString();
			System.out.println("Enter the amount for which you want to buy you share ");
			int buyingAmount=Utility.userInputInteger();
			stockAccount.buy(buyingAmount,name2);
			break;
			
		
		
		case 3: stockAccount.printReport();
		break;
		}
			
		System.out.println("Do you want to continue(Y/N)");
		if(Utility.userInputString().equals("Y")) {
			keepGoing=true;
		}
		else {
			keepGoing=false;
		}
		
	}
		
		
		
		
	}

}
