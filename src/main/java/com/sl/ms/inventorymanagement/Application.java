package com.sl.ms.inventorymanagement;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sl.ms.inventorymanagement.dao.InventoryRepository;
import com.sl.ms.inventorymanagement.dao.ProductsRepository;
import com.sl.ms.inventorymanagement.sql.domain.Inventory;
import com.sl.ms.inventorymanagement.sql.domain.Product;

import net.minidev.json.JSONArray;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	CommandLineRunner commandLineRunner (InventoryRepository InventoryRepository, ProductsRepository productsRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				InventoryRepository.save(new Inventory(1, new Date(), new JSONArray()));
				productsRepository.save(new Product(1, "parle-g", 10, 10));
				productsRepository.save(new Product(1, "marigold", 10, 20));
				productsRepository.save(new Product(1, "rusk",30, 30));
			}
		};
	}
}
