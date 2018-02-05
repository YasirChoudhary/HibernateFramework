package com.hibernateMapping.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(103);
		laptop.setLname("HP");
		
		
		Student student = new Student();
		student.setRollno(2);
		student.setName("Yasir");
		student.setMarks(65);
		student.getLaptop().add(laptop);
		
		// laptop should know student object for adding rollno column
		laptop.setStudent(student);
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		session.save(student);
		session.save(laptop);
		txn.commit();
	
		
		
		sf.close();
	}

}
