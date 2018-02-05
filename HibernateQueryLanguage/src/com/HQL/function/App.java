package com.HQL.function;

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
		System.out.println("------------FROM CLAUSE: hql = 'SELECT sum(age) FROM Customer C'------------");
	
		String hql = "SELECT count(*) FROM Customer C";
		Query query= session.createQuery(hql);
		Object count= query.uniqueResult();
		System.out.println("Number of Customers : "+count);
		
		System.out.println("***************************************");
		
		String hql1 = "SELECT sum(age) FROM Customer C WHERE C.age>21";
		Query query1= session.createQuery(hql1);
		Object ageObj= query1.uniqueResult();
		System.out.println("Sum of Ages : "+ageObj);
		txn.commit();
		
		session.close();
		sf.close();
	}
}
