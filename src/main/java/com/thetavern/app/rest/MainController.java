package com.thetavern.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thetavern.app.service.EmployeeService;

/**
 * @author Fernando Nathanael
 *
 */
@Controller
@RequestMapping("/thetavern")
public class MainController {

	private EmployeeService employeeService;

	@Autowired
	public MainController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/asdf")
	public String showHome() {
		return "index";
	}

	@GetMapping("/admin/employees")
	public String showEmployeesTable() {
		return "employees";
	}

	@GetMapping("/helloworld")
	public String showHelloWorldPage(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());
		theModel.addAttribute("theEmployee", employeeService.findById(1).getName());

		return "helloworld";
	}

}
