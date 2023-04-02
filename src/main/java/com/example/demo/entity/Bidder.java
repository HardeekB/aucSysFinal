package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
    private String contact;
    
   @OneToMany(targetEntity = Inventory.class , cascade = CascadeType.ALL)
	//@JoinColumn(name="bidder_id_fk",referencedColumnName = "id")
	private List<Inventory> auctionItems = new ArrayList<>();
    
    
   /* @OneToMany(mappedBy = "bidder")
    private List<Inventory> auctionItems = new ArrayList<>();
    */
	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Bidder(int id, String name, String password, String email, String contact, List<Inventory> auctionItems) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.auctionItems = auctionItems;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}


	public List<Inventory> getAuctionItems() {
		return auctionItems;
	}


	public void setAuctionItems(List<Inventory> auctionItems) {
		this.auctionItems = auctionItems;
	}
    
	


}
