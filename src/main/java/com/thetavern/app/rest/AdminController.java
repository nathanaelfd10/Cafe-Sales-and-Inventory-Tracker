package com.thetavern.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thetavern.app.service.EmployeeService;

/**
 * @author Fernando Nathanael
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private EmployeeService employeeService;

	@Autowired
	public AdminController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/")
	public String showAdminPanel() {
		return "dashboard";
	}
	
	@GetMapping("/employees")
	public String showEmployeesTable() {
		return "employees";
	}

}
