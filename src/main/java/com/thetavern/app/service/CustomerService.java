package com.thetavern.app.service;

import java.util.List;

import com.thetavern.app.entity.Customer;

/**
 * @author Fernando Nathanael
 *
 */
public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
