package com.HQL.WHEREClause;

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
		System.out.println("------------WHERE CLAUSE: hql = 'FROM Customer C where C.age=22'------------");
		
		/*
		 * When we are saying from and not mentioning any we get the
		 * list of object of a particular class 
		 */
		String hql = "FROM Customer C where C.age=22";
		Query query= session.createQuery(hql);
		List<Customer> custList = query.list();
		for(Customer customer:custList) {
			System.out.println(customer);
		}
		
		System.out.println("*****************************************************");
		
		String hql1 ="FROM Customer C where C.age>20";
		Query query1 = session.createQuery(hql1);
		List<Customer> custLists= query1.list();
		for(Customer customer: custLists) {
			System.out.println(customer);
		}
		
		System.out.println("*****************************************************");
		
		String hql2 = "SELECT C.firstName, C.age FROM Customer C where C.age>20";
		Query query3= session.createQuery(hql2);
		List<Object[]> custObj= query3.list();
		for(Object[] customer: custObj) {
			System.out.println(customer[0]+" : "+customer[1]);
		}
		txn.commit();
		
		session.close();
		sf.close();
	}
}
