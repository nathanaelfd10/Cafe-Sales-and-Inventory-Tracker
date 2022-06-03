package com.janjimanis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.janjimanis.app.dao.MenuDAO;
import com.janjimanis.app.entity.Menu;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	
	public MenuServiceImpl() {
		
	}
	
	@Autowired
	public MenuServiceImpl(MenuDAO theMenuDAO) {
		menuDAO = theMenuDAO;
	}
	
	@Override
	@Transactional
	public List<Menu> findAll() {
		return menuDAO.findAll();
	}

	@Override
	@Transactional
	public Menu findById(int theId) {
		return menuDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Menu theMenu) {
		menuDAO.save(theMenu);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		menuDAO.deleteById(theId);
	}

}
