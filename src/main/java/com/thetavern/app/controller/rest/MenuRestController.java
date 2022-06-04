package com.thetavern.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
