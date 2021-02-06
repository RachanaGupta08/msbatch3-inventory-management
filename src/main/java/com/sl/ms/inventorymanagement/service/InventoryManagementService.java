/*
 * package com.sl.ms.inventorymanagement.service;
 * 
 * import java.util.List;
 * 
 * import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.sl.ms.inventorymanagement.dao.InventoryRepository; import
 * com.sl.ms.inventorymanagement.dao.ProductsRepository; import
 * com.sl.ms.inventorymanagement.dto.InventoryDetails; import
 * com.sl.ms.inventorymanagement.sql.domain.Inventory;
 * 
 * @Service public class InventoryManagementService {
 * 
 * @Autowired private InventoryRepository inventoryRepository;
 * 
 * @Autowired private ProductsRepository productsRepository;
 * 
 * public List<Inventory> getAllInventorys() { return
 * inventoryRepository.findAll(); }
 * 
 * public InventoryDetails getInventoryDetails(Integer inventoryId) { Inventory
 * inventory =
 * inventoryRepository.findById(inventoryId).orElseThrow(RuntimeException::new);
 * 
 * List<Item> itemList = itemsRepository.findByInventoryId(inventoryId); return
 * new InventoryDetails(inventory, itemList); }
 * 
 * public String saveInventoryByInventoryId(Integer inventoryId,
 * InventoryDetails details) { Inventory inventory = details.getInventory();
 * inventory.setId(inventoryId); inventoryRepository.save(inventory);
 * 
 * details.getItems().forEach(item -> { item.setInventoryId(inventoryId);
 * itemsRepository.save(item); }); return "inventory saved successfully!"; }
 * 
 * public String deleteInventoryByInventoryId(Integer inventoryId) {
 * 
 * InventoryDetails details = getInventoryDetails(inventoryId);
 * 
 * details.getItems().forEach(item -> { item.setInventoryId(inventoryId);
 * itemsRepository.delete(item); });
 * 
 * inventoryRepository.delete(details.getInventory()); return
 * "inventory deleted successfully!"; } }
 */