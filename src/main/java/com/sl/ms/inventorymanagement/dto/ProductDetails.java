package com.sl.ms.inventorymanagement.dto;

import java.util.List;

import com.sl.ms.inventorymanagement.sql.domain.Product;

public class ProductDetails {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	}
