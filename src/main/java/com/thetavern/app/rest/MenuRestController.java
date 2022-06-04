package com.janjimanis.app.rest;

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

import com.janjimanis.app.dao.CustomerDAO;
import com.janjimanis.app.entity.Customer;
import com.janjimanis.app.entity.Employee;
import com.janjimanis.app.entity.Menu;
import com.janjimanis.app.service.EmployeeService;
import com.janjimanis.app.service.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuRestController {

	private MenuService menuService;


	@Autowired
	public MenuRestController(MenuService theMenuService) {
		menuService = theMenuService;
	}



}
