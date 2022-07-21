package com.commercialdataprocessing;

public class CompanyShares {
	
	int numberOfShares;
	String stockSymbol;
	String transactionDateTime;

	public CompanyShares() {
		super();
	}
	
	public CompanyShares(int numberOfShares, String stockSymbol,String transactionDateTime) {
		super();
		this.numberOfShares = numberOfShares;
		this.stockSymbol = stockSymbol;
		this.transactionDateTime = transactionDateTime;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	
	
}
