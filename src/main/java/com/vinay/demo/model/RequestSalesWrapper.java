package com.vinay.demo.model;

public class RequestSalesWrapper {

	private Sales[] sales;
	
	private int totalLineItems;
	private double totalCostVal;
	
	public Sales[] getSales() {
		return sales;
	}
	public void setSales(Sales[] sales) {
		this.sales = sales;
	}
	public int getTotalLineItems() {
		return totalLineItems;
	}
	public void setTotalLineItems(int totalLineItems) {
		this.totalLineItems = totalLineItems;
	}
	public double getTotalCostVal() {
		return totalCostVal;
	}
	public void setTotalCostVal(double totalCostVal) {
		this.totalCostVal = totalCostVal;
	}
	
	
}
