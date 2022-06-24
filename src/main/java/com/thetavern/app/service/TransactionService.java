/**
 * 
 */
package com.thetavern.app.service;

import java.util.List;

import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
public interface TransactionService {

	public List<Transaction> findAll();

	public Transaction findById(int theId);

	public void save(Transaction theTransaction, List<Integer> menuId);

	public void deleteById(int theId);
	
}
