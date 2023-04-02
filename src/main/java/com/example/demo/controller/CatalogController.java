package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.AuctionEventRepository;



@Controller
public class CatalogController {
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	//@Autowired
	//private BidderRepository bidderRepo;
	
	public static final String uploadingdDirInventory = System.getProperty("user.dir") + "/src/main/webapp/catalogimage" ; 
	public static final String uploadingdDirAuction = System.getProperty("user.dir") + "/src/main/webapp/auctionimage" ;
	
	@RequestMapping(value ="/auctionCatalog" , method = RequestMethod.GET )
	public String auctionCatalog(HttpServletRequest request) {
		Cookie[] c1 = request.getCookies();
		
		if(c1 != null) {
			for(Cookie c : c1) {
				if(c.getName().equals("auctioneer")) {
					return "auctionCatalog";
				}
			}
			
			return "redirect:/auctioneer/signIn";
		}
		return "redirect:/auctioneer/signIn";
	}
	

	@RequestMapping(value = "/auctionhouse/auction" , method = RequestMethod.POST) 
	public String addAuction(@ModelAttribute AuctionEvent auctionEvent , @RequestParam("auctionImage") MultipartFile fileAuction,@RequestParam("name") ArrayList<String> itemName ,  @RequestParam("image") ArrayList<MultipartFile> file  , @RequestParam("start_bid") ArrayList<Integer> start_bid , @RequestParam("descInventory") ArrayList<String>  descInventory) {
    try{	 
    	String filenameAuction=fileAuction.getOriginalFilename();	    
    	Path fileNameAndPathAuction =Paths.get(uploadingdDirAuction,filenameAuction);
			try {
			      Files.write(fileNameAndPathAuction, fileAuction.getBytes());
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			     e.printStackTrace();
	    }
	    auctionEvent.setAutionImage(filenameAuction);
    	
			
		int n = itemName.size();
		ArrayList<Inventory> list = new ArrayList<Inventory>();
		for(int i=0 ; i<n ;i++) {
			Inventory inventory = new Inventory();
			inventory.setName(itemName.get(i));
			inventory.setStart_bid(start_bid.get(i));
			inventory.setDescInventory(descInventory.get(i));
			
			
	        MultipartFile f=file.get(i);      
	        String filename=f.getOriginalFilename();
	        Path fileNameAndPath =Paths.get(uploadingdDirInventory,filename);
	        try {
	            Files.write(fileNameAndPath, f.getBytes());
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	               e.printStackTrace();
	        }
	        inventory.setImage(filename);
	        list.add(inventory);
	        
		}
		auctionEvent.setAuction_items(list);
		auctionRepo.save(auctionEvent);
		return "redirect:/auctioneer/dashboard";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Home";
			
		}
	}
	
	/*@ResponseBody
	@RequestMapping(value ="/invenotoryByBidderId/{id}" , method = RequestMethod.GET )
	public List<Inventory> getAllAuctionItems(@PathVariable("id") int id) {
		System.out.println("List Type " +bidderRepo.findAuctionItemsByBidder(id).getClass());
		return bidderRepo.findAuctionItemsByBidder(id);
	}*/
	
	/*@ResponseBody
	@RequestMapping(value ="/bidderByInventoryId/{id}" , method = RequestMethod.GET )
	public Bidder getBidderByAuctionItems(@PathVariable("id") int id) {
		return bidderRepo.findByAuctionItems_InventoryId(id);
	}*/
	
	
}
