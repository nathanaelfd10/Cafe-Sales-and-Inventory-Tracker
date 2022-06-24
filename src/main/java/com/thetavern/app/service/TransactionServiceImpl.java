/**
 * 
 */
package com.thetavern.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thetavern.app.dao.TransactionDAO;
import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO;

	@Autowired
	public TransactionServiceImpl(TransactionDAO theTransactionDAO) {
		transactionDAO = theTransactionDAO;
	}

	@Override
	@Transactional
	public List<Transaction> findAll() {
		return transactionDAO.findAll();
	}

	@Override
	@Transactional
	public Transaction findById(int theId) {
		return transactionDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Transaction theTransaction, List<Integer> menuId) {
		transactionDAO.save(theTransaction, menuId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		transactionDAO.deleteById(theId);
	}

}
