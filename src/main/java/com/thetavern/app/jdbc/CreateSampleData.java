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
			Employee tempEmployee2 = new Employee("Ferdi", "1913-08-12", "M", "Jl Kebon", "1000000", "Cashier", true);
			Employee tempEmployee3 = new Employee("Matthew", "1913-09-11", "M", "Jl Gading", "1000000", "Cashier", true);
			Employee tempEmployee4 = new Employee("Dauphine", "1913-05-27", "F", "Jl Pahlawan", "1000000", "Cashier", false);
			Employee tempEmployee5 = new Employee("Louisa", "1913-08-12", "F", "Jl Pejaten", "1000000", "Cashier", true);

			Customer tempCustomer1 = new Customer("patricia", "patricia123", "2001-12-23", true);
			Customer tempCustomer2 = new Customer("joni", "cafemantul123", "2001-01-01", true);
			Customer tempCustomer3 = new Customer("udin", "123456", "2001-02-01", true);
			Customer tempCustomer4 = new Customer("jono", "mamamia", "2001-12-23", true);
			Customer tempCustomer5 = new Customer("sukirman", "lezatooos", "2001-03-01", true);
			Customer tempCustomer6 = new Customer("kamarudin", "masasihhahaha", "2001-06-01", true);

			Menu tempMenu1 = new Menu("Espresso", "This is a description about espresso idk probably tastes bitter i guess", "espresso.jpg", 5, true);
			Menu tempMenu2 = new Menu("Caffe Latte", "A desc about caffe latte", "caffelatte.jpg", 5, true);
			Menu tempMenu3 = new Menu("Croissant", "A very crunchy croissant", "croissant.jpg", 5, true);
			Menu tempMenu4 = new Menu("Milk Tea", "This is a description about milk tea", "milktea.jpg", 5, true);
			Menu tempMenu5 = new Menu("French Fries", "A desc about french fries", "fries.jpg", 5, true);
			Menu tempMenu6 = new Menu("Green Tea Latte", "A desc about green tea latter", "greentealatter.jpg", 5, true);
			
			// begins transaction
			session.beginTransaction();
			
			// saves transaction
			session.save(tempEmployee0);
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			session.save(tempEmployee5);

			session.save(tempCustomer1);
			session.save(tempCustomer2);
			session.save(tempCustomer3);
			session.save(tempCustomer4);
			session.save(tempCustomer5);
			session.save(tempCustomer6);

			session.save(tempMenu1);
			session.save(tempMenu2);
			session.save(tempMenu3);
			session.save(tempMenu4);
			session.save(tempMenu5);
			session.save(tempMenu6);

			// commits transaction
			session.getTransaction().commit();
						
		} finally {
			factory.close();
		}
		
		
	}

}
