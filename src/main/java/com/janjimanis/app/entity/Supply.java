package com.janjimanis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	

}
