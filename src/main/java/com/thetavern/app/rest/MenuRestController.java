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

import com.thetavern.app.dao.CustomerDAO;
import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Employee;
import com.thetavern.app.entity.Menu;
import com.thetavern.app.service.EmployeeService;
import com.thetavern.app.service.MenuService;

/**
 * @author Fernando Nathanael
 *
 */
@RestController
@RequestMapping("/api/menus")
public class MenuRestController {

	private MenuService menuService;


	@Autowired
	public MenuRestController(MenuService theMenuService) {
		menuService = theMenuService;
	}



}
