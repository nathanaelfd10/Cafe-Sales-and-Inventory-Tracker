package com.thetavern.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.thymeleaf.util.StringUtils;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "price")
	private int price;

	@Column(name = "available")
	private Boolean available;

	@Column(name = "category")
	private String category;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "transaction_detail", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "transaction_id"))
	private List<Transaction> transactions;

	public Menu() {

	}

	public Menu(String name, String description, String image, int price, Boolean available) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.available = available;
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

		try {
			String capitalizedName = StringUtils.capitalizeWords(name);
			this.name = capitalizedName;
		} catch (Exception e) {
			System.err.println("[Menu] Failed to capitalize words: " + name);
			this.name = name;
		}

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
				+ price + ", available=" + available + ", category=" + category + "]";
	}

}
