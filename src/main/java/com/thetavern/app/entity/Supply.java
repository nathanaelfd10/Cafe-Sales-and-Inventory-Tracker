package com.thetavern.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.thymeleaf.util.StringUtils;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name = "supply")
public class Supply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "stock")
	private int stock;

	@Column(name = "unit")
	private String unit;

	@Column(name = "category")
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Supply() {
		super();
	}

	public Supply(String name, String description, int price, int stock, String unit) {
		super();
		this.name = name;
		this.description = description;
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

		String capitalizedName = StringUtils.capitalizeWords(name);

		this.name = capitalizedName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	@Override
	public String toString() {
		return "Supply [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", unit=" + unit + ", category=" + category + "]";
	}

}
