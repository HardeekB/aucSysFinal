package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Auctioneer;

@Repository
public interface AuctioneerRepository  extends JpaRepository<Auctioneer, Integer>{
	
	boolean existsByEmail(String email);
	
	Auctioneer findByEmail(String email);


}
