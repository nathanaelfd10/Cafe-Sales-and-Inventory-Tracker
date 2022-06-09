package com.thetavern.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="date_of_birth")
	private String dateofBirth;
	
	@Column(name="is_member")
	private Boolean isMember;
	
	@OneToMany(mappedBy="customer", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Transaction> transactions;
		
	public Customer() {
		
	}

	public Customer(String name, String password, String dateofBirth, Boolean isMember) {
		super();
		this.name = name;
		this.password = password;
		this.dateofBirth = dateofBirth;
		this.isMember = isMember;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public Boolean getIsMember() {
		return isMember;
	}

	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", dateofBirth=" + dateofBirth
				+ ", isMember=" + isMember + "]";
	}
	
	public void add(Transaction theTransaction) {
		if (transactions == null) {
			transactions = new ArrayList<>();
		}
		
		transactions.add(theTransaction);
		
		theTransaction.setCustomer(this);
	}
	
}
