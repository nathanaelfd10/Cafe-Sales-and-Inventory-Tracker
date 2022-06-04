package com.thetavern.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thetavern.app.dao.CustomerDAO;
import com.thetavern.app.entity.Customer;

/**
 * @author Fernando Nathanael
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl() {
		
	}

	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}

	@Override
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

}
