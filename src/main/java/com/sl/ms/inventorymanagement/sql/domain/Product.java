package com.sl.ms.inventorymanagement.sql.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SL_PRODUCT")
public class Product {

	
	  /**
	   * @param id
	   * @param name
	   * @param price
	   * @param quantity
	   */
	  public Product(Integer id, String name, int price, int quantity) {
	  	super();
	  	this.id = id;
	  	this.name = name;
	  	this.price = price;
	  	this.quantity = quantity;
	  }
	  public Product() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Integer price;


	@Column(name = "quantity")
	private Integer quantity;
}
