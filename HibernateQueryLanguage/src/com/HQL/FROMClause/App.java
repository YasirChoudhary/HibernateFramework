package com.HQL.FROMClause;



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
		System.out.println("------------FROM CLAUSE: hql = 'FROM Customer'------------");
		
		String hql = "FROM Customer";
		Query<Customer> query = session.createQuery(hql, Customer.class);
		List<Customer> custList= query.list();
		for(Customer c: custList) {
			System.out.println(c);
		}
		// custList.forEach(System.out::println);
		
		txn.commit();
		
		session.close();
		sf.close();
	}
}
