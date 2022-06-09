/**
 * 
 */
package com.thetavern.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction {

//	@OneToMany(mappedBy="transaction_details", cascade = CascadeType.REMOVE, orphanRemoval = true)
//	private List<TransactionDetail> transactionDetails;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "date")
	private String date;

	@Column(name = "total")
	private double total;

	@Column(name = "tax")
	private double tax;

	@Column(name = "customer_type")
	private String customerType;

	public Transaction() {
		super();
	}

	public Transaction(String date, double total, double tax, String customerType) {
		super();
		this.date = date;
		this.total = total;
		this.tax = tax;
		this.customerType = customerType;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}