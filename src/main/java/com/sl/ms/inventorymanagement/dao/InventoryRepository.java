package com.sl.ms.inventorymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.ms.inventorymanagement.sql.domain.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	}
