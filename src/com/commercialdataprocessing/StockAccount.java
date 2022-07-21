package com.commercialdataprocessing;


import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;

public class StockAccount implements Account {

	public String filename;
	CompanyShares[] companyShares;
	CompanyShares[] cmpyShares;
	static double balance;
	static double value;
	String symbol;
	int numberOfCompanyShare=0;

	String transactionDateTime="Date : "+LocalDate.now()+" Time : "+LocalTime.now();
	 
	
	public StockAccount() { super();}

	public StockAccount(String filename) {
		companyShares = new CompanyShares[6];
		this.filename = filename;
	}
	@Override
	public double valueOf() {			
		value = 1000.0;
		return value;
	}
	@Override
	public void buy(int amount, String symbol) {
		System.out.println("  ------  Buying Shares  ----  ");
		
		 StockAccount stockAccount = new StockAccount();
		 if(numberOfCompanyShare == 0) {
			 balance = stockAccount.valueOf();}
		 System.out.println("  Number of Company Share : "+numberOfCompanyShare);
		 System.out.println("  Stock Symbol : "+ symbol);
		 System.out.println("  Value before buying share : "+balance);
		 balance = balance-amount;
		 companyShares[numberOfCompanyShare] = new CompanyShares(numberOfCompanyShare, symbol, transactionDateTime);
				 
		 System.out.println("  Company Share Price "+amount);
		 System.out.println("  Value after buying share :"+balance);
		 System.out.println("  Transaction Date And Time : "+companyShares[numberOfCompanyShare].transactionDateTime+"\n");
		 numberOfCompanyShare++;
	}
	@Override
	public void sell(int amount, String symbol) {
		System.out.println("  ------  Selling Shares  ----  ");
		numberOfCompanyShare=0;
		for(int i = 0; i < companyShares.length; i++ )
		{       
			if(companyShares[i].getStockSymbol() == symbol){
				System.out.println(" Number of Company Share : "+numberOfCompanyShare);
				System.out.println(" Balance before sell share : "+balance);	
				System.out.println(" Selling share price : "+amount);
				System.out.println(" Stock Symbol : "+symbol);
				companyShares[numberOfCompanyShare] = new CompanyShares(numberOfCompanyShare, symbol, transactionDateTime);
				
				balance = balance + amount;	
				System.out.println(" Balance After sell share : "+balance);
				System.out.println(" Transaction time and Date :"+companyShares[numberOfCompanyShare].transactionDateTime+"\n");
				//cmpyShares[i]=companyShares[i];
				// 	 not able to understad what should i do with sold share	
			}else if (this.companyShares[i].getStockSymbol() == null)
			{
				System.out.println(" wrong input");
			}
			//companyShares[i]=cmpyShares[i];
		numberOfCompanyShare++;
		}		
	}
	@Override
	public void save(String filename) {
		System.out.println("\n  ------  File Save   ----  ");
		System.out.println(" File Saved : "+filename); //don't have data base to store
		
	}
	@Override
	public void printReport() {
		System.out.println("\n  ------  Final Report  ----  ");
		System.out.println(" Inital value  was : "+StockAccount.value);
		if(StockAccount.value < StockAccount.balance) {
		double totalProfit = StockAccount.balance - StockAccount.value;
		System.out.println(" After selling all the shares of company, \n current value is : "+StockAccount.balance+" \n So, Total Profit is  : "+totalProfit);

		}
		else if (StockAccount.balance < StockAccount.value){
			double totalLoss = StockAccount.value-StockAccount.balance;
	        System.out.println(" After selling all the shares of company,\n current value is : "+StockAccount.balance+" \n So, Total Loss is  : "+totalLoss);		
		}
		
		
	}
	
	public static void main (String [] args) throws Exception{
		// create Class Object
		StockAccount stockAccount = new StockAccount(" Ravi Singh");
		System.out.println("  FileName : "+stockAccount.filename+"\n");
		
		//Buying  Company Shares 
		stockAccount.buy(30,"Tata");
		stockAccount.buy(50,"Bata");
		stockAccount.buy(78,"Amazon");
		stockAccount.buy(53,"ebay");
		stockAccount.buy(83,"fb");
		stockAccount.buy(86,"google");
		
		//Selling Company Shares
		stockAccount.sell(56,"Tata");
		stockAccount.sell(90,"Amazon");
		stockAccount.sell(98,"ebay");
		stockAccount.sell(142,"google");
		stockAccount.sell(160,"fb");
		stockAccount.sell(120,"Bata");
		
		//StockAccount save with file name 
		stockAccount.save(stockAccount.filename);
		
		//Print Final report
		stockAccount.printReport();
		
		
		Gson gson = new Gson();
		String json = gson.toJson(stockAccount);
		try {
			FileWriter writer = new FileWriter("D:/Code/commercialdataprocessing/src/com/commercialdataprocessing/CompanyShares.json"); 
			writer.write(json);
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println(" : "+e);
		}		
	}	
}
