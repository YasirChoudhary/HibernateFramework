package com.HQL.NamedParameter;



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
		
		System.out.println("---------NAMED PARAMETERS CLAUSE: hql = FROM Customer C WHERE C.id = 1-----------");
		
		String hql = "FROM Customer C where C.id= :customerId";
		Query query = session.createQuery(hql);
		query.setParameter("customerId", 101);
		List<Customer> custList = query.list();
		for(Customer customer: custList) {
			System.out.println(customer);
		}
		
		txn.commit();
		
		session.close();
		sf.close();
	}
}
