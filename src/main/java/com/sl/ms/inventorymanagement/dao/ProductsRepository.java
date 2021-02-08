package com.sl.ms.inventorymanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sl.ms.inventorymanagement.sql.domain.Product;



@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer>{
	
	  @Query(value = "select * from SL_PRODUCT where id=:productId", nativeQuery =
	  true) public List<Product> findByProductId( @Param("productId") Integer
	  productId);
	 
}