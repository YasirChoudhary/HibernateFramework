package com.Read;

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
		
		// Reading Data from database
		StudentDTO student = session.load(StudentDTO.class, 106);
		System.out.println(student);
		
		session.close();
		sf.close();
	}

}
