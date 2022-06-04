package com.thetavern.app.service;

import java.util.List;

import com.thetavern.app.entity.Menu;

/**
 * @author Fernando Nathanael
 *
 */
public interface MenuService {

	public List<Menu> findAll();
	
	public Menu findById(int theId);
	
	public void save(Menu theMenu);
	
	public void deleteById(int theId);
	
}
