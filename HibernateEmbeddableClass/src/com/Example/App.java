package com.Example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		StudentName sn = new StudentName();
		sn.setFname("Yasir Ahmed");
		sn.setMname("Anis Ahmed");
		sn.setLname("Choudhary");
		
		Student student = new Student();
		student.setId(101);
		student.setSname(sn);
		student.setBranch("Computer Engineering");
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		session.save(student);
		txn.commit();
		
		session.close();
		sf.close();
	}

}
