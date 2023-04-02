package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId; //inventory_id
     
    private int soldPrice;
    private int start_bid;
    private String descInventory;
    private String name;
    private String image;
    private boolean isSold = false;
    
    @ManyToOne
    private Bidder bidder;
     

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Inventory(int inventoryId, int soldPrice, int start_bid, String descInventory, String name, String image,
			boolean isSold, Bidder bidder) {
		super();
		this.inventoryId = inventoryId;
		this.soldPrice = soldPrice;
		this.start_bid = start_bid;
		this.descInventory = descInventory;
		this.name = name;
		this.image = image;
		this.isSold = isSold;
		this.bidder = bidder;
	}


	public int getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}


	public int getSoldPrice() {
		return soldPrice;
	}


	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}


	public int getStart_bid() {
		return start_bid;
	}


	public void setStart_bid(int start_bid) {
		this.start_bid = start_bid;
	}


	public String getDescInventory() {
		return descInventory;
	}


	public void setDescInventory(String descInventory) {
		this.descInventory = descInventory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean getIsSold() {
		return isSold;
	}


	public void setIsSold(boolean isSold) {
		this.isSold = isSold;
	}


	public Bidder getBidder() {
		return bidder;
	}


	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	
	
     
}
