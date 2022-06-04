package com.janjimanis.app.dao;

import java.util.List;

import com.janjimanis.app.entity.Employee;
import com.janjimanis.app.entity.Menu;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

}
