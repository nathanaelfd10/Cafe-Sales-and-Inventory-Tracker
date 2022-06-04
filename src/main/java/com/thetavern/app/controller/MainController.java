package com.thetavern.app.controller;

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
@RequestMapping("/")
public class MainController {

	private EmployeeService employeeService;

	@Autowired
	public MainController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/")
	public String showHome() {
		return "template";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}

	@GetMapping("/helloworld")
	public String showHelloWorldPage(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());
		theModel.addAttribute("theEmployee", employeeService.findById(1).getName());

		return "helloworld";
	}

}
