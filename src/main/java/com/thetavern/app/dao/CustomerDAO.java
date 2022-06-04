package com.thetavern.app.dao;

import java.util.List;

import com.thetavern.app.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

}
