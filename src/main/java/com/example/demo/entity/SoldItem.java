package com.example.demo.entity;


public class SoldItem {
	
	
	private int inventoryId;
	private int soldPrice;
	private int bidderId;
	private String bidderName;
	
	public SoldItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SoldItem(int inventoryId, int soldPrice, int bidderId, String bidderName) {
		super();
		this.inventoryId = inventoryId;
		this.soldPrice = soldPrice;
		this.bidderId = bidderId;
		this.bidderName = bidderName;
	}



	public int getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}


	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}


	public String getBidderName() {
		return bidderName;
	}


	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	
		
}
