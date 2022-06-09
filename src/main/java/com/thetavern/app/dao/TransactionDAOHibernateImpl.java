/**
 * 
 */
package com.thetavern.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
@Repository
public class TransactionDAOHibernateImpl implements TransactionDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public TransactionDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Transaction> findAll() {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// creates query
		Query<Transaction> theQuery = currentSession.createQuery("from Transaction", Transaction.class);
		
		// gets all supplies
		List<Transaction> theTransactions = theQuery.getResultList();
		
		return theTransactions;
	}

	@Override
	public Transaction findById(int theId) {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// gets supply
		Transaction theTransaction = currentSession.get(Transaction.class, theId); 
		
		return theTransaction;
	}

	@Override
	public void save(Transaction theTransaction) {
		
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theTransaction);
		
	}

	@Override
	public void deleteById(int theId) {
		// gets session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete the object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Transaction where id=:transactionId");
		
		theQuery.setParameter("transactionId", theId);
		
		theQuery.executeUpdate();
		
	}

}
