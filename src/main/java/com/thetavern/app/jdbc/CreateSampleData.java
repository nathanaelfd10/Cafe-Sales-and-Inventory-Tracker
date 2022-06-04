package com.thetavern.app.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.thetavern.app.entity.Customer;
import com.thetavern.app.entity.Employee;
import com.thetavern.app.entity.Menu;

/**
 * @author Fernando Nathanael
 *
 */
public class CreateSampleData {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Menu.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// creates object
			System.out.println("Creating new Employee object..");
			Employee tempEmployee0 = new Employee("Patricia", "1914-12-23", "F", "Jl Kelapa", "99999999", "Admin", true);
			Employee tempEmployee1 = new Employee("Fernando", "1913-10-10", "M", "Jl H Kaiman", "1000000", "Cashier", true);
			Customer tempCustomer1 = new Customer("patricia", "patricia123", "2001-12-23", true);
			Customer tempCustomer2 = new Customer("joni", "cafemantul123", "2001-01-01", true);
			Customer tempCustomer3 = new Customer("udin", "123456", "2001-02-01", true);
			Menu tempMenu1 = new Menu("Espresso", "This is a description about espresso idk probably tastes bitter i guess", "espresso.jpg", 5, true);
			Menu tempMenu2 = new Menu("Caffe Latte", "A desc about caffe latte", "caffelatte.jpg", 5, true);
			Menu tempMenu3 = new Menu("Croissant", "A very crunchy croissant", "croissant.jpg", 5, true);
			
			
			// begins transaction
			session.beginTransaction();
			
			// saves transaction
			session.save(tempEmployee0);
			session.save(tempEmployee1);
			session.save(tempCustomer1);
			session.save(tempCustomer2);
			session.save(tempCustomer3);
			session.save(tempMenu1);
			session.save(tempMenu2);
			session.save(tempMenu3);

			// commits transaction
			session.getTransaction().commit();
						
		} finally {
			factory.close();
		}
		
		
	}

}
