/**
 * 
 */
package com.thetavern.app.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Transaction;

/**
 * @author Fernando Nathanael
 *
 */
public class CreateTransaction {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Transaction.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects
			/*
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");		
			*/
			
			session.beginTransaction();
			
			int theId = 1;
			Customer tempCustomer = session.get(Customer.class, theId);		
			
			Transaction tempTransaction =
					new Transaction("2022-06-09", 10000, 1000, "GRAB");
			
			
			// associate the objects
			tempCustomer.add(tempTransaction);
			
			
			// save the instructor
			session.save(tempTransaction);
			
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
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
