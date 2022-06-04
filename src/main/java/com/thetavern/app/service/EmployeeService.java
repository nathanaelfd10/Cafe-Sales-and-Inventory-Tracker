package com.thetavern.app.service;

import java.util.List;

import com.thetavern.app.entity.Employee;

/**
 * @author Fernando Nathanael
 *
 */
public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
