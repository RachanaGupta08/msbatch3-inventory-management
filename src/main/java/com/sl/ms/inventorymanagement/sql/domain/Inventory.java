package com.sl.ms.inventorymanagement.sql.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import net.minidev.json.JSONArray;



@Entity
@Table(name = "SL_INV")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "date")
	private Date date;

	@Lob
	String file;

	/**
	 * @param id
	 * @param date
	 * @param string
	 */
	public Inventory(Integer id, Date date, JSONArray string) {
		super();
		this.id = id;
		this.date = date;
		this.file = string.toJSONString();
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

}
