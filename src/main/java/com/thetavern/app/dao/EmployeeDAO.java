package com.thetavern.app.dao;

import java.util.List;

import com.thetavern.app.entity.Employee;

/**
 * @author Fernando Nathanael
 *
 */
public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

}
