package com.thetavern.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thetavern.app.entity.Employee;
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
	public String showEmployees(Model theModel) {
		
		List<Employee> employees = employeeService.findAll();
		
		theModel.addAttribute("employees", employees);
		
		return "employees";
		
	}

}
