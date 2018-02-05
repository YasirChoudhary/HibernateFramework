package com.Delete;

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
		
		// Deleting Data from database
		StudentDTO student = session.load(StudentDTO.class, 106);
		Transaction txn = session.beginTransaction();
		session.delete(student);
		txn.commit();

		session.close();
		sf.close();
	}

}
