package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Bidder;
import com.example.demo.repository.AuctionEventRepository;
import com.example.demo.repository.BidderRepository;



@Controller
public class BidderController {
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET )
	public String Home() {
		return "Home";
	}
	
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "bidderSignUp";
	}
	 
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Bidder b , Model m) {
		
		if(bidderRepo.existsByEmail(b.getEmail())) {
			m.addAttribute("message", "email already exists , try another one");
			return "bidderSignUp";
		}
		System.out.println("Bidder added");
		bidderRepo.save(b);
	
		m.addAttribute("message", "Signed Up Successfully");
		return "bidderSignIn";
	}
	
	
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "bidderSignIn";
	}
	
	/*@ResponseBody
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost(@ModelAttribute("bidder1") Bidder b) {
		
		
		  Bidder bidder = bidderRepo.findByEmail(b.getEmail());
		  
		  if(b.getPassword().equals(bidder.getPassword()))
		  { return "Sign in successful"; }
		 
		
		return "bidderSignIn";
	}*/
	
	
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost( HttpServletResponse response , @RequestParam("email") String email , @RequestParam("password")String password ,  Model m ) {
		
		  if(!bidderRepo.existsByEmail(email)) {
				m.addAttribute("message", "email doesn't exists , Sign up here");
				return "bidderSignUp";
			}
		  
		  Bidder bidder = bidderRepo.findByEmail(email);
		  
		  if(password.equals(bidder.getPassword()))
		  { 
			  Cookie c = new Cookie("bidder", email);
			  c.setPath("/");
			  response.addCookie(c);
			  
			  return "redirect:/bidder/dashboard"; 
		 }
		 
		 m.addAttribute("message", "Wrong Credentials! , try again");
		 return "bidderSignIn";	  
	}
	
	
	@RequestMapping( value = "/bidder/dashboard" , method = RequestMethod.GET)
	public String bidderDashboard(HttpServletRequest request ,  Model model) {
		
        Cookie[]  c1 =request.getCookies();
        
        if(c1 != null) {     
			for (Cookie c: c1)
        	{
			 	if(c.getName().equals("bidder"))
			 	{
				 	List<AuctionEvent> auctionList = auctionRepo.findAll(); 
				 	model.addAttribute("auctionList", auctionList);
				 	return "bidderDashboard";
	        	}
        	}
		
			return "redirect:/bidder/signIn";
        }
   
    	return "redirect:/bidder/signIn";
	}
	
	
	@RequestMapping( value = "/bidder/event/{event_id}" , method = RequestMethod.GET)
	public String eventView(HttpServletRequest request , @PathVariable("event_id")int event_id , Model model) {
		
		String cookieinemail = null;
        Cookie[]  c1 =request.getCookies();
        if(c1 != null) { 
        	for (Cookie c: c1)
        	{
        		System.out.println("Name :"+c.getName()+" Email :"+c.getValue());
        	
        		if(c.getName().equals("bidder"))
        		{
        			cookieinemail=c.getValue();
        			System.out.println("Bidder : "+cookieinemail);
                
        			AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
        			model.addAttribute("auctionName", event.getEventName());
        			model.addAttribute("description" , event.getDescAuction());
        			model.addAttribute("items", event.getAuction_items());
                
	                Bidder b = bidderRepo.findByEmail(cookieinemail);
	                model.addAttribute("bidderId", b.getId());
	                model.addAttribute("bidderName", b.getName());
	                
	        		return "bidderEventView";
        		}
        	}
        	return "redirect:/bidder/signIn";
        }
       
        return "redirect:/bidder/signIn";
	}
	
	
	@RequestMapping( value = "/bidder/logout" , method = RequestMethod.GET)
	public String eventView(HttpServletRequest request ,  HttpServletResponse response) {
		
		Cookie[] c = request.getCookies();
	       for(int i=0; i<c.length; i++)
	       {
	           if(c[i].getName().equals("bidder"))
	           {
	        	   c[i].setPath("/");
	        	   c[i].setMaxAge(0);
	        	   response.addCookie(c[i]);
	        	   break;
	           }
	       }  
	     return "redirect:/bidder/signIn";
	}
}
