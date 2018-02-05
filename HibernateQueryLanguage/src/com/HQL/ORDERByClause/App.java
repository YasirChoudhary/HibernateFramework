package com.HQL.ORDERByClause;



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
		System.out.println("------------ORDER BY CLAUSE: hql = 'FROM Customer C WHERE C.age > 20 ORDER BY C.id DESC '------------");
		
		String hql = "FROM Customer C WHERE C.age>20 ORDER BY C.id DESC";
		Query query= session.createQuery(hql);
		List<Customer> custList= query.list();
		System.out.println(custList);
		for(Customer customer: custList) {
			System.out.println(customer);
		}
		
		txn.commit();
		
		session.close();
		sf.close();
	}
}
