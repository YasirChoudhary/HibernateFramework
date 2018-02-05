package com.HQL.SELECTClause;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {
	
	public static void main(String[] args) {
		
		/*Customer cust = new Customer();*/
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Customer.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		System.out.println("-----------SELECT CLAUSE: hql = SELECT C.firstName, C.age FROM Customer C--------");
		
		/*when we specify columns we get Objects here we are not talking about the entire row in table
		 here we are talking specific columns in the table. That's why we are using here List<Object[]> instead 
		 of List<Customer>
		*/
		
		
		// 1)First Example of SELECT Clause.
		/* 
		String hql ="SELECT C.firstName, C.age from Customer C";
		Query query= session.createQuery(hql);
		List<Object[]> objectList = query.list();
		
		for(Object[] obj: objectList) {
			System.out.println(obj[0]+":"+obj[1]);
		}
		*/
		
		String hql = "SELECT  id, firstName, lastName, age from Customer where id=101";
		Query query= session.createQuery(hql);
		// Unique result will return us four object of 101 results id, firstName, lastName, age
		Object[] obj= (Object[]) query.uniqueResult(); 
		
		System.out.println(obj[0]+" : "+obj[1]+" : "+obj[2]+" : "+obj[3]);
		System.out.println("***************************************");
		for(Object custObj: obj) {
			System.out.println(custObj);
		}
		txn.commit();
		
		session.close();
		sf.close();
	}
}
