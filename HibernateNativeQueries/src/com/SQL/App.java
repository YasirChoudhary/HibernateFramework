package com.SQL;



import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


public class App {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Customer.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txn = session.beginTransaction();
		
		String sql="SELECT * FROM Customer WHERE age>20";
		//SQLQuery query= session.createSQLQuery(sql);
		NativeQuery query= session.createNativeQuery(sql);
		query.addEntity(Customer.class);
		List<Customer> custList = query.list();
		
		for(Customer customer: custList) {
			System.out.println(customer);
		}
		
		System.out.println("*********************************************************");
		
		// Second one is easy to create Native Queries
		String sql2 = "SELECT * FROM Customer WHERE id>102";
		Query query2= session.createNativeQuery(sql2,Customer.class);
		List<Customer> customers = query2.list();
		for(Customer cust: customers) {
			System.out.println(cust);
		}
		
		System.out.println("*********************************************************");
		
		
	
		/*String sql3="SELECT id,name FROM Customer WHERE id>102";
		Query query3 = session.createNativeQuery(sql3, Customer.class);
		query3.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP) ;
		List<Customer> custListss= query3.list();
		for(Object c: custListss) {
			Map m = (Map)c;
			System.out.println(m.get("id")+" : "+m.get("marks"));
		}*/
		
		txn.commit();
		
		session.close();
		sf.close();
	}
}
