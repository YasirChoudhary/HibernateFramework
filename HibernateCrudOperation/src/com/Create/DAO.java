package com.Create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAO {
	
	public static void main(String[] args) {
		
		StudentDTO student = new StudentDTO();
		student.setId(106);
		student.setName("Ahmed");
		student.setAge(22);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(StudentDTO.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		session.save(student);
		txn.commit();
		
		session.close();
		sf.close();
	}

}
