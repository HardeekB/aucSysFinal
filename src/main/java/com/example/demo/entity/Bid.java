package com.example.demo.entity;

public class Bid {
	
	private int inventoryId;
	private int bidderId;
	private String bidderName;
	private int newBidValue;
	
	
	public Bid() {
	
	}
	
	public Bid(int inventoryId, int bidderId, String bidderName, int newBidValue) {
		super();
		this.inventoryId = inventoryId;
		this.bidderId = bidderId;
		this.bidderName = bidderName;
		this.newBidValue = newBidValue;
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
	
	

	public String getBidderName() {
		return bidderName;
	}



	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}



	public int getNewBidValue() {
		return newBidValue;
	}

	public void setNewBidValue(int newBidValue) {
		this.newBidValue = newBidValue;
	}



	

	
	
	
}
