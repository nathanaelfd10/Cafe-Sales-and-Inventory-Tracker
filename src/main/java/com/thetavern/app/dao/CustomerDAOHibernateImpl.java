package com.thetavern.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Employee;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {
	

	// define field for entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public CustomerDAOHibernateImpl(EntityManager theEntityManager) {
		super();
		this.entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Customer> findAll() {		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
				
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get customer
		Customer theCustomer = currentSession.get(Customer.class, theId);

		// return customer
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public void deleteById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}
	


}
