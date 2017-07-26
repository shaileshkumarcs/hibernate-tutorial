package com.shailesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shailesh.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("Creating 3 student objcet....");
			Student tempStudent1 = new Student("Kumar", "Dangi", "kumar@gmail.com");
			Student tempStudent2 = new Student("sunita", "Dangi", "sunita@gmail.com");
			Student tempStudent3 = new Student("Dangi", "Manita", "manita@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
