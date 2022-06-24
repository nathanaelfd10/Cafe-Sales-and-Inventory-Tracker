/**
 * 
 */
package com.thetavern.app.dto;

import java.util.List;

import com.thetavern.app.entity.Menu;

/**
 * @author Fernando Nathanael
 *
 */
public class MenusDTO {
	private List<Menu> menus;
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
