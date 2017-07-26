package com.shailesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.cglib.reflect.FastConstructor;

import com.shailesh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory  = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try{
			// create the student object
			System.out.println("Creating new student objcet....");
			Student tempStudent = new Student("Suman","kumar","suman@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student....");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			//My New Code
			
			
			//Find out the student id primary key
			System.out.println("Saved student. Generated id: "+tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retreive student based on the id:primary key
			System.out.println("\nGetting student with id : "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get Complete: "+ myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally{
			factory.close();
		}
	}

}
