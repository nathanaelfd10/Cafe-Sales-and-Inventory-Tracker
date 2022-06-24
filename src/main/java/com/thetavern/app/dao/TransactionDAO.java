package com.thetavern.app.dao;

import java.util.List;

import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
public interface TransactionDAO {

	public List<Transaction> findAll();

	public Transaction findById(int theId);

	public void save(Transaction theTransaction, List<Integer> menuId);

	public void deleteById(int theId);

}
