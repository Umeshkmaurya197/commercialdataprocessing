package com.commercialdataprocessing;

public interface Account {

		public double valueOf();
		public void buy(int amount, String symbol);
		public void sell(int amount, String symbol);
		public void save(String filename);
		public void printReport();
}
