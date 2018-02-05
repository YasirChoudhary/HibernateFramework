package com.HQL.DELETEClause;



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
		System.out.println("---------UPDATE Clause: hql = 'DELETE FROM Customer WHERE id = :customerID' --------");
		
		String hql = "DELETE FROM Customer WHERE id = :customerID ";
		
		Query query= session.createQuery(hql);
		query.setParameter("customerID", 108);
		int affectedRows = query.executeUpdate();
		
		System.out.println("Number of rows affected :"+affectedRows);
		txn.commit();
		
		session.close();
		sf.close();
	}
}
