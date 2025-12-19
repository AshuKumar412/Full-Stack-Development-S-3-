package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		//Load Configuration & Create The SessionFactory
		SessionFactory factory=new Configuration()
				.configure().buildSessionFactory();
		
		//Open Session
		Session session = factory.openSession();
		
		//Begin Transaction
		Transaction tx = session.beginTransaction();
		
		//Create the table/object
		Student s=new Student("Ravi");
		
		// Save the data/object
		session.save(s);
		
		//Commit
		tx.commit();
		
		//Close the connection
		session.close();
		factory.close();
		
		System.out.println("Student data inserted successfully");

	}

}