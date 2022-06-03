package com.janjimanis.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.janjimanis.app.entity.Menu;

@Repository
public class MenuDAOHibernateImpl implements MenuDAO {
	

	// define field for entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public MenuDAOHibernateImpl(EntityManager theEntityManager) {
		super();
		this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Menu> findAll() {		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Menu> theQuery = 
				currentSession.createQuery("from Menu", Menu.class);
				
		
		// execute query and get result list
		List<Menu> menus = theQuery.getResultList();
		
		// return the results
		return menus;
	}

	@Override
	public Menu findById(int theId) {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);	
		
		// get menu
		Menu theMenu =
				currentSession.get(Menu.class, theId);
		
		// return menu
		return theMenu;
	}

	@Override
	public void save(Menu theMenu) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theMenu);
		
	}

	@Override
	public void deleteById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
	
		// delete object with primary key
		Query theQuery =
				currentSession.createQuery(
						"delete from Menu where id=:menuId");
		
		theQuery.setParameter("menuId", theId);
		
		theQuery.executeUpdate();
	}

	
}
