/**
 * 
 */
package com.thetavern.app.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Menu;
import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
public class CreateTransactionDetail {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Transaction.class)
								.addAnnotatedClass(Menu.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			int theId = 1;
			
			Menu tempMenu = session.get(Menu.class, theId);
			
			Transaction tempTransaction = session.get(Transaction.class, theId);	
			
			tempTransaction.addMenu(tempMenu);
			
			
			// save the instructor
			session.save(tempTransaction);
			

			System.out.println("Saving transaction: " + tempTransaction);				
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}
	
}
