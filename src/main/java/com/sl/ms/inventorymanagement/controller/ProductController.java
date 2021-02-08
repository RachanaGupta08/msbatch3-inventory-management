package com.sl.ms.inventorymanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.inventorymanagement.dao.ProductsRepository;
import com.sl.ms.inventorymanagement.dto.ProductDetails;
//import com.sl.ms.inventorymanagement.dto.Product;
import com.sl.ms.inventorymanagement.sql.domain.Product;

@RestController
public class ProductController {

	ProductsRepository productRepo;

	public ProductController(ProductsRepository productRepo) {
		this.productRepo = productRepo;
	}

	@GetMapping("/products")
	public Iterable<Product> getProducts() {
		return productRepo.findAll();
	}

	@GetMapping("/products/{id}")
	public Product getbyId(@PathVariable int id) {
		return productRepo.findByProductId(id).get(0);
	}

	@PostMapping(value = "/products/{id}", consumes = "application/json", produces = "application/json")
	public Product saveById(@PathVariable int id, @RequestBody Product product) {
		Product p = new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
		/*
		 * p.setName(p.getName()); p.setName(p.getName());
		 */
		System.out.print("Name:" + p.getName());
		return productRepo.save(p);
	}

	/*
	 * @PostMapping(value = "/products", consumes = "application/json", produces =
	 * "application/json") public Iterable<Product> saveAll(@RequestBody
	 * Iterable<Product> p) { System.out.print("Name:" + p.toString()); return
	 * productRepo.saveAll(p); }
	 */
	@PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
	public Iterable<Product> saveAll(@RequestBody ProductDetails productDetails) {
		List<Product> p = productDetails.getProducts().stream().collect(Collectors.mapping(product -> 
		new Product(product.getId(),product.getName(),product.getPrice(),product.getQuantity()), Collectors.toList()));
		System.out.print("Name:" + p.toString());
		return productRepo.saveAll(p);
	}

	@PutMapping(value = "/products/{id}", consumes = "application/json", produces = "application/json")
	public Product updateById(@PathVariable int id, @RequestBody Product p) {
		p.setId(id);
		System.out.print("Name:" + p.getName());
		return productRepo.save(p);
	}

	@DeleteMapping(value = "/products/{id}")
	public void deleteById(@PathVariable int id) {
		Product p = productRepo.findByProductId(id).get(0);
		p.setQuantity(0);
		productRepo.save(p);
	}

	@GetMapping("/supported_products")
	public HashMap<Integer, String> getSupportedProducts() {
		HashMap<Integer, String> uniqueMap = new HashMap<Integer, String>();

		productRepo.findAll().forEach(p -> {
			uniqueMap.put(p.getId(), p.getName());
		});
		return uniqueMap;
	}
}