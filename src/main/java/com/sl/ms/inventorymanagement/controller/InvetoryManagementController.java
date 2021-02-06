//package com.sl.ms.inventorymanagement.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sl.ms.inventorymanagement.dto.InventoryDetails;
//import com.sl.ms.inventorymanagement.service.InvetoryManagementService;
//import com.sl.ms.inventorymanagement.sql.domain.Inventory;
//
//@RestController
//public class InvetoryManagementController {
//
//	@Autowired
//	private InvetoryManagementService inventoryManagementService;
//	
//	@GetMapping("/inventorys")
//	public ResponseEntity<List<Inventory>> getAllInventorys()
//	{
//		List<Inventory> inventorys= inventoryManagementService.getAllInventorys();
//		return new ResponseEntity<>(inventorys, HttpStatus.OK);
//	}
//	
//	@GetMapping("/inventorys/{inventory_id}")
//	public ResponseEntity<InventoryDetails> getInventoryById(@PathVariable(name = "inventory_id") Integer inventoryId)
//	{
//		 InventoryDetails inventoryDetails = inventoryManagementService.getInventoryDetails(inventoryId);
//		return new ResponseEntity<>(inventoryDetails, HttpStatus.OK);
//	}
//	@PostMapping(value = "/inventorys/{inventory_id}", consumes = "application/json")
//	public ResponseEntity<String> saveInventory(@PathVariable(name = "inventory_id") Integer inventoryId, @RequestBody InventoryDetails inventoryDetails) {
//		 String sucessMsg = inventoryManagementService.saveInventoryByInventoryId(inventoryId, inventoryDetails);
//		return new ResponseEntity<>(sucessMsg, HttpStatus.CREATED);
//	}
//	
//	@DeleteMapping("/inventorys/{inventory_id}")
//	public ResponseEntity<String> updateProduct(@PathVariable(name = "inventory_id") Integer inventoryId) {
//		String sucessMsg = inventoryManagementService.deleteInventoryByInventoryId(inventoryId);
//		return new ResponseEntity<>(sucessMsg, HttpStatus.ACCEPTED);
//	}
//}
