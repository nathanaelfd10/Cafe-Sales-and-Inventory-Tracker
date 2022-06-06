/**
 * 
 */
package com.thetavern.app.service;

import java.util.List;

import com.thetavern.app.entity.Supply;

/**
 * @author Fernando Nathanael
 *
 */
public interface SupplyService {
	
	public List<Supply> findAll();
	
	public Supply findById(int theId);

	public void save(Supply theSupply);

	public void deleteById(int theId);

}
