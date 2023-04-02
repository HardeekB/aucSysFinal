package com.example.demo.controller;

//https://www.youtube.com/watch?v=MH9tm2WYS68
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Bid;
import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.SoldItem;
import com.example.demo.repository.BidderRepository;
import com.example.demo.repository.InventoryRepository;


@Controller
public class WebController {
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@Autowired
	private BidderRepository bidderRepo;
	
	
	@MessageMapping("/addBid")
	@SendTo("/bid/newBid")
	public Bid increaseBib(Bid b)throws InterruptedException
	{
		
		return new Bid(b.getInventoryId() ,b.getBidderId(), b.getBidderName() , b.getNewBidValue());			
	
	}
	
	
	
	@MessageMapping("/bidCompleted")
	@SendTo("/bid/placebid") 
	public SoldItem completedBid(SoldItem soldItem) {
		
		
		Bidder b = bidderRepo.findById(soldItem.getBidderId()).orElse(null);
		
		Inventory inv = inventoryRepo.findById(soldItem.getInventoryId()).orElse(null);
		inv.setSoldPrice(soldItem.getSoldPrice());
		inv.setIsSold(true);
		inv.setBidder(b);
		
		
		List<Inventory> listInventory = bidderRepo.findAuctionItemsByBidder(soldItem.getBidderId());
	
		listInventory.add(inv);
		
	
		b.setAuctionItems(listInventory);
		
		bidderRepo.save(b);
		
		
		return soldItem;
	}

}
