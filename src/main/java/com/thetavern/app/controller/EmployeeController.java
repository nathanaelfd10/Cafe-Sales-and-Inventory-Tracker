package com.thetavern.app.controller;

import java.util.ArrayList;
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
import com.thetavern.app.entity.Transaction;
import com.thetavern.app.service.MenuService;
import com.thetavern.app.service.SupplyService;
import com.thetavern.app.service.TransactionService;

/**
 * @author Fernando Nathanael
 *
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private MenuService menuService;
	private SupplyService supplyService;
	private TransactionService transactionService;
	
	@Autowired
	public EmployeeController(
			MenuService theMenuService, 
			SupplyService theSupplyService, 
			TransactionService theTransactionService)
	{	
		menuService = theMenuService;
		supplyService = theSupplyService;
		transactionService = theTransactionService;
	}
	
	@GetMapping({"", "/"})
	public String redirectToDashboard() {
		return "redirect:/employee/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String showHome(Model theModel) {
		
		return "/employee/dashboard";
	}
	
	/* Cashier Panel */
	@GetMapping("/cashier-panel")
	public String showCashierPanel(
			@RequestParam(name="itemCount", defaultValue= "5") int itemCount, 
			@RequestParam(value="selectedMenus", required=false) List<Integer> selectedMenuId,
			Model theModel) {

		Transaction transaction = new Transaction();
		
		List<Menu> availableMenus = menuService.findAll();
		
		// [] To-do: Try to append item to RequestParam		
		List<Menu> listOfMenus = new ArrayList<>();
		
		if(selectedMenuId != null) {
			for(int menuId : selectedMenuId) {
				Menu menu = menuService.findById(menuId);
				if(menu != null)
					listOfMenus.add(menu);
			}
			
		}	
		
		// Initialize empty menus
		int emptyFields = itemCount-listOfMenus.size();
		for(int i=0; i<emptyFields; i++) {
			listOfMenus.add(new Menu());
		}
		
		// Calculate total price
		int totalPrice = calculateTotalPrice(listOfMenus);
				
		// Calculate tax
		int tax = calculateTax(totalPrice);
		
		theModel.addAttribute("transaction", transaction);
		theModel.addAttribute("availableMenus", availableMenus);
		theModel.addAttribute("selectedMenus", listOfMenus);
		theModel.addAttribute("totalPrice", totalPrice);
		theModel.addAttribute("tax", tax);
		


		return "/employee/cashier-panel";
	}

	private int calculateTotalPrice(List<Menu> listOfMenus) {
		int totalPrice = 0;
		
		for (Menu menu : listOfMenus) {
			totalPrice += menu.getPrice();
		}
		
		return totalPrice;
	}

	
	public int calculateTax(int totalPrice) {
		// (10% of totalPrice)
		int tax = totalPrice/10;
		return tax;
	}
	
	/* Save transaction */
	@PostMapping("/cashier-panel/save-transaction")
	public String saveTransaction(Transaction theTransaction) {
				
		List<Integer> listOfMenuId = new ArrayList<>();
		
		transactionService.save(theTransaction, listOfMenuId);
		
		return "/employee/cashier-panel";
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

	
	@GetMapping("/testing")
	public String testingMethod() {
		Transaction newTransaction = new Transaction("2022-06-09", 10000, 1000, "GRAB");
		
		
		List<Integer> listOfMenuId = new ArrayList<>();
		listOfMenuId.add(1);
		listOfMenuId.add(2);
		
//		Menu newMenu = new Menu(1, "Chocolate", "Choco choco", "chocolate.jpg", 15000, true);
	
		transactionService.save(newTransaction, listOfMenuId);
		
		return "redirect:/employee/inventory-management";
	}
	
}
