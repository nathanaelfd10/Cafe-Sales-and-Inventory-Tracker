/**
 * 
 */
package com.thetavern.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thetavern.app.dao.SupplyDAO;
import com.thetavern.app.entity.Supply;

/**
 * @author Fernando Nathanael
 *
 */
@Service
public class SupplyServiceImpl implements SupplyService {

	private SupplyDAO supplyDAO;
	
	@Autowired
	public SupplyServiceImpl(SupplyDAO theSupplyDAO) {
		supplyDAO = theSupplyDAO;
	}

	@Override
	public List<Supply> findAll() {
		return supplyDAO.findAll();
	}

	@Override
	public Supply findById(int theId) {
		return supplyDAO.findById(theId);
	}

	@Override
	public void save(Supply theSupply) {
		supplyDAO.save(theSupply);
	}

	@Override
	public void deleteById(int theId) {
		supplyDAO.deleteById(theId);
	}

}
