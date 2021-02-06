package com.sl.ms.inventorymanagement.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import org.apache.tomcat.util.json.JSONParser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sl.ms.inventorymanagement.dao.InventoryRepository;
import com.sl.ms.inventorymanagement.dao.ProductsRepository;
import com.sl.ms.inventorymanagement.sql.domain.Inventory;
import com.sl.ms.inventorymanagement.sql.domain.Product;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@RestController
public class InventoryProductController {

	ProductsRepository productRepo;
	InventoryRepository inventoryRepo;

	public InventoryProductController(ProductsRepository productRepo, InventoryRepository inventoryRepo) {
		this.productRepo = productRepo;
		this.inventoryRepo = inventoryRepo;
	}

	@RequestMapping(value = "/products/file", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("date") Date date,
			@RequestParam("id") Integer id) {

		Inventory inv;
		Set<Product> prodList = new HashSet<Product>();
		try {
			// JSON parser object to parse read file
			@SuppressWarnings("deprecation")
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(file.getInputStream());
			JSONArray productList = (JSONArray) obj;
			System.out.println(productList);

			// Iterate over employee array
			productList.forEach(prd -> parseProductObject((JSONObject) prd, prodList));
			System.out.println("Data" + prodList);

			inv = new Inventory(id, date, productList);

		} catch (IOException | net.minidev.json.parser.ParseException e) {
			inv = new Inventory();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventoryRepo.save(inv);

		return "Success";

	}

	private void parseProductObject(JSONObject prd, Set<Product> prodList) {

		Product p = new Product(((Integer) prd.get("id")).intValue(), (String) prd.get("name"),
				((Integer) prd.get("price")).intValue(), (Integer) prd.get("quantity"));
		prodList.add(p);
		productRepo.save(p);
	}

}
