package com.Update;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAO {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(StudentDTO.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		// Update Data in the database
		StudentDTO student = session.load(StudentDTO.class, 106);
		student.setName("Yasir Choudhary");
		Transaction txn = session.beginTransaction();
		session.update(student);
		txn.commit();
		System.out.println(student);
		
		session.close();
		sf.close();
	}

}
