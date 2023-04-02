package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.CatalogController;

@SpringBootApplication
public class AuctionSiteApplication {

	public static void main(String[] args) {
		
		new File(CatalogController.uploadingdDirAuction).mkdir();
		new File(CatalogController.uploadingdDirInventory).mkdir();
		SpringApplication.run(AuctionSiteApplication.class, args);
		System.out.println("App Started...");
		/*System.out.println("DirAuction = "+ CatalogController.uploadingdDirAuction);
		System.out.println("DirInventory = "+ CatalogController.uploadingdDirInventory);*/
		
	}

}
