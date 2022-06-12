package com.thetavern.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping({ "", "/" })
	public String redirectToDashboard() {
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/dashboard")
	public String showAdminPanel() {
		return "dashboard";
	}
	
	@GetMapping("/signup")
	public String showSignUpPage() {
		
		return "asdf";
	}

	@GetMapping("/employees")
	public String showEmployees(Model theModel) {

		List<Employee> employees = employeeService.findAll();
		
		theModel.addAttribute("employees", employees);

		return "admin/employee-management/table";

	}

	@GetMapping("/employees/add")
	public String addNewEmployee(Model theModel) {
		
		// model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "admin/employee-management/add-form";
	}

	@GetMapping("/employees/update")
	public String addNewEmployee(@RequestParam("id") int theId, Model theModel) {

		// get employee data by id
		Employee theEmployee = employeeService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to the form
		return "admin/employee-management/update-form";
	}

	@PostMapping("/employees/save")
	public String saveEmployee(Employee theEmployee) {
		
		employeeService.save(theEmployee);

		return "redirect:/admin/employees";

	}

	@GetMapping("/employees/delete")
	public String deleteEmployee(@RequestParam("id") int theId) {

		employeeService.deleteById(theId);

		return "redirect:/admin/employees";
	}

}
