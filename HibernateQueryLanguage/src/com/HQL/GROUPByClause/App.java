package com.HQL.GROUPByClause;



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
		
		System.out.println("---------------GROUP BY CLAUSE: hql = SELECT COUNT(*), C.firtName FROM Customer C --------------");
		
		String hql = "SELECT COUNT(*), C.firstName FROM Customer C GROUP BY C.firstName";
		Query query= session.createQuery(hql);
		List<Object[]> objList = query.list();
		for(Object[] customer: objList) {
			System.out.println(customer[0]+" : "+customer[1]);
		}
		
		txn.commit();
		
		session.close();
		sf.close();
	}
}
