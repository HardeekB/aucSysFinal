package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Integer>{
	public Bidder findByEmail(String email);

	public boolean existsByEmail(String email);
	
	@Query("SELECT auctionItems FROM Bidder b WHERE b.id = ?1")
	public List<Inventory> findAuctionItemsByBidder(int id);
	
	public Bidder findByAuctionItems_InventoryId(int id);
	

}
