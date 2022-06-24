/**
 * 
 */
package com.thetavern.app.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.thetavern.app.entity.Menu;
import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */

public class TransactionDAOTest {
	
	
	public static void main(String[] args) {

		Transaction newTransaction = new Transaction("06/22/2022", 15000, 1500, "Grab");
//		List<Menu> listOfMenusChosenByCustomerIdk = new ArrayList<>();
		List<Transaction> transactionList = new ArrayList<>();
		
		Menu newMenu = new Menu(1, "Chocolate", "Choco choco", "chocolate.jpg", 15000, true);
		Menu newMenu2 = new Menu(2, "Chocolate 2", "Chocolatey", "chocolate.jpg", 15000, true);
		
		newTransaction.addMenu(newMenu);
		newTransaction.addMenu(newMenu2);
		
		transactionList.add(newTransaction);
		
		System.out.println(newTransaction);
		
		
	}

}
