package com.shailesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.cglib.reflect.FastConstructor;

import com.shailesh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory  = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try{
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retreive student based on the id:primary key
			System.out.println("\nGetting student with id : "+studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			
			// delete the Student
			//System.out.println("Delete student : "+ myStudent);
			//session.delete(myStudent);
			
			// delete student id=2
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();				
			
			System.out.println("Done!");
			
		}
		finally{
			factory.close();
		}
	}

}
