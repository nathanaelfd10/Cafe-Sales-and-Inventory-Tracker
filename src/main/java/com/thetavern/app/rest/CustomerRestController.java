package com.thetavern.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Employee;
import com.thetavern.app.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("")
	public List<Customer> findAllEmployees() {
		return customerService.findAll();
	}

	// mapping for GET /employees/{customerId}
	@GetMapping("{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);
		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}

		return theCustomer;
	}
	
	@PostMapping("")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		// just in case they pass 0 as an id in JSOn
		theCustomer.setId(0);
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("{customerId}")
	public Customer Customer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.findById(customerId);
		
		// throw exception if null
		if (tempCustomer == null) {
			throw new RuntimeException("Employee id not found - " + customerId);
		}
		
		customerService.deleteById(customerId);
		
		return tempCustomer;
	}

}
