package com.hibernateMapping.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("HP");
		
		Student student = new Student();
		student.setRollno(1);
		student.setName("Yasir");
		student.setMarks(65);
		student.getLaptop().add(laptop);
		
		laptop.getStudent().add(student);
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		session.save(laptop);
		session.save(student);
		
		txn.commit();
	
		
		
		sf.close();
	}

}
