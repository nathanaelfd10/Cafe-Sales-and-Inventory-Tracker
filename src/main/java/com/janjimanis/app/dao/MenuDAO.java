package com.janjimanis.app.dao;

import java.util.List;

import com.janjimanis.app.entity.Menu;

public interface MenuDAO {
	
	public List<Menu> findAll();
	
	public Menu findById(int theId);

	public void save(Menu theMenu);

	public void deleteById(int theId);
	
}
