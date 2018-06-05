package com.bridgelabz.objectorientedprgms;

import com.bridgelabz.util.Utility;

public class CompanyManagement {
	public static void main(String[] args) {
		
			System.out.println("creating a new account...");
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
				
		
			
		}
		
	}

}
