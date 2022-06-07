package com.thetavern.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name="supply")
public class Supply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="desc")
	public String desc;
	
	@Column(name="price")
	public String price;
	
	@Column(name="stock")
	public int stock;
	
	@Column(name="unit")
	public String unit;

	public Supply() {
		super();
	}
	
	public Supply(String name, String desc, String price, int stock, String unit) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.stock = stock;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	

}
