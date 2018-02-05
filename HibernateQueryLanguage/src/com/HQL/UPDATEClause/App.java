package com.HQL.UPDATEClause;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Customer.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		System.out.println("------UPDATE Clause: hql = 'UPDATE Customer set age = :custAge WHERE id = :customerId'");
		
		String hql = "UPDATE Customer set age = :custAge WHERE id = :customerId ";
		Query query= session.createQuery(hql);
		
		query.setParameter("custAge", 22);
		query.setParameter("customerId", 104);
		int affectedRows = query.executeUpdate();
		
		System.out.println("Number of Rows Affected : "+affectedRows);
		txn.commit();
		
		session.close();
		sf.close();
	}
}
