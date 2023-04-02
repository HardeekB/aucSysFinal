package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AuctionEvent;


@Repository
public interface AuctionEventRepository extends JpaRepository<AuctionEvent, Integer>{
	
}
