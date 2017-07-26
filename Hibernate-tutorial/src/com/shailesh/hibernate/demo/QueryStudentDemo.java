package com.shailesh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shailesh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory  = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try{
			
			// start a transaction
			session.beginTransaction();
			
			// Query students
			List<Student> theStudent = session.createQuery("from Student").list();
			
			// display students
			displayStuents(theStudent);
			
			//Query students : lastName =Dangi
			theStudent = session.createQuery("from Student s where s.lastName='Dangi'").list();
			
			//display the students
			System.out.println("Students who have last name of Dangi");
			displayStuents(theStudent);
			
			// query students: lastName 'Dangi'  Or FirstName='manita'
			theStudent = session.createQuery("from Student s where s.lastName='Dangi' OR s.firstName='Dangi'").list();

			System.out.println("\n\nStudents who have last name of Dangi Or first name kumar");
			displayStuents(theStudent);
			
			// query students where email LIKE 'gmail.com'
			theStudent = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			
			System.out.println("\n\n Students whose email ends with gmail.com");
			displayStuents(theStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally{
			factory.close();
		}
	}

	private static void displayStuents(List<Student> theStudent) {
		for(Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}

}
