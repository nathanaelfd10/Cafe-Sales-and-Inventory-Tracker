/**
 * 
 */
package com.thetavern.app.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Fernando Nathanael
 *
 */

public class TransactionDetail {

	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="transaction_id")
	private Transaction transaction;
	
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;
	
}
