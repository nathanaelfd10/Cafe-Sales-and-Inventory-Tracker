/**
 * 
 */
package com.thetavern.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.thetavern.app.entity.Supply;

/**
 * @author Fernando Nathanael
 *
 */
@Repository
public class SupplyDAOHibernateImpl implements SupplyDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Supply> findAll() {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// creates query
		Query<Supply> theQuery = currentSession.createQuery("from supply", Supply.class);
		
		// gets all supplies
		List<Supply> theSupplies = theQuery.getResultList();
		
		return theSupplies;
	}

	@Override
	public Supply findById(int theId) {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// gets supply
		Supply theSupply = currentSession.get(Supply.class, theId); 
		
		return theSupply;
	}

	@Override
	public void save(Supply theSupply) {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theSupply);
		
	}

	@Override
	public void deleteById(int theId) {
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete the object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Supply where id=:supplyId");
		
		theQuery.setParameter("supplyId", theId);
		
		theQuery.executeUpdate();
		
	}

}
