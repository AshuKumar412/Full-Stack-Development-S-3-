package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp {

	public static void main(String[] args) {
		
       //load  configuration & create session factory
		
		SessionFactory factory = new Configuration()    // to configure the the database means check all the database is suitable for connection or not
				.configure().buildSessionFactory();
		
		//open Session
		
		Session session = factory.openSession();         
		
		// begin transaction
		
		Transaction tx = session.beginTransaction();    
		
		// create object
		
		Student s = new Student("Ashu");  // this method is used to create the table in Database and insert the row if we passed the parameter
		
		// Save object
		
		session.save(s);
		
		// commit
		
		tx.commit();
		
		// close the resources
		
		session.close();
		factory.close();
		
		System.out.println("Data has been inserted successfully");
	}

}
