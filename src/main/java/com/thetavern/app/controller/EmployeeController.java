package com.thetavern.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thetavern.app.entity.Menu;
import com.thetavern.app.entity.Supply;
import com.thetavern.app.service.MenuService;
import com.thetavern.app.service.SupplyService;

/**
 * @author Fernando Nathanael
 *
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private MenuService menuService;
	private SupplyService supplyService;
	
	@Autowired
	public EmployeeController(MenuService theMenuService, SupplyService theSupplyService) {
		menuService = theMenuService;
		supplyService = theSupplyService;
	}
	
	@GetMapping("/dashboard")
	public String showHome(Model theModel) {
		
		return "/employee/dashboard";
	}
	
	/* Queries all data from db and show in both table */
	@GetMapping("/inventory-management")
	public String showInventoryMenu(Model theModel) {
		
		List<Menu> theMenus = menuService.findAll();
		List<Supply> theSupplies = supplyService.findAll();
		
		theModel.addAttribute("menus", theMenus);
		theModel.addAttribute("supplies", theSupplies);
		
		return "employee/inventory-management/table";
	}
	
	
	/* CRUD for Menu */
	@GetMapping("/inventory-management/add-menu") 
	public String showAddMenuForm(Model theModel) {
		
		Menu theMenu = new Menu();
		
		theModel.addAttribute("menu", theMenu);
		
		return "employee/inventory-management/add-menu-form";
	}
	
	@GetMapping("/inventory-management/update-menu")
	public String showUpdateMenuForm(@RequestParam("id") int theId, Model theModel) {
		
		Menu theMenu = menuService.findById(theId);
		
		theModel.addAttribute("menu", theMenu);		
		
		return "employee/inventory-management/update-menu-form";
	}
	
	@PostMapping("/inventory-management/save-menu")
	public String saveMenu(Menu theMenu) {
		
		menuService.save(theMenu);
		
		return "redirect:/employee/inventory-management";
		
	}
	
	@GetMapping("/inventory-management/delete-menu")
	public String deleteMenu(@RequestParam("id") int theId) {
		
		menuService.deleteById(theId);
		
		return "redirect:/employee/inventory-management";
		
	}
	
	
	/* CRUD for Supply */
	@GetMapping("/inventory-management/add-supply") 
	public String showAddSupplyForm(Model theModel) {
		
		Supply theSupply = new Supply();
		
		theModel.addAttribute("supply", theSupply);
		
		return "employee/inventory-management/add-supply-form";
	}
	
	@GetMapping("/inventory-management/update-supply")
	public String showUpdateSupplyForm(@RequestParam("id") int theId, Model theModel) {
		
		Supply theSupply = supplyService.findById(theId);
		
		theModel.addAttribute("supply", theSupply);		
		
		return "employee/inventory-management/update-supply-form";
	}
	
	@PostMapping("/inventory-management/save-supply")
	public String saveSupply(Supply theSupply) {
		
		supplyService.save(theSupply);
		
		return "redirect:/employee/inventory-management";
		
	}
	
	@GetMapping("/inventory-management/delete-supply")
	public String deleteSupply(@RequestParam("id") int theId) {
		
		supplyService.deleteById(theId);
		
		return "redirect:/employee/inventory-management";
		
	}
	
}
