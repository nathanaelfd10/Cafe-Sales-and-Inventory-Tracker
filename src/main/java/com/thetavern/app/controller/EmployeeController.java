package com.thetavern.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

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
	
	@GetMapping("/inventory-management")
	public String showInventoryMenu(Model theModel) {
		
		List<Menu> theMenus = menuService.findAll();
		List<Supply> theSupplies = supplyService.findAll();
		
		theModel.addAttribute("menus", theMenus);
		theModel.addAttribute("supplies", theSupplies);
		
		return "employee/inventory-management/table";
	}
	
	@GetMapping("/inventory-management/add-supply") 
	public String showAddSupplyForm(Model theModel) {
		
		Supply theSupply = new Supply();
		
		theModel.addAttribute("supply", theSupply);
		
		return "employee/inventory-management/add-supply-form";
	}
	
	@PostMapping("/inventory-management/save-supply")
	public String saveSupply(Supply theSupply) {
				
		String supplyName = StringUtils.capitalize(theSupply.getName());
		
		theSupply.setName(supplyName);
		
		supplyService.save(theSupply);
		
		return "redirect:/employee/inventory-management";
		
	}
	
	@GetMapping("/inventory-management/delete")
	public String deleteSupply(@RequestParam("id") int theId) {
		
		supplyService.deleteById(theId);
		
		return "redirect:/employee/inventory-management";
		
	}
	
}
