package com.hibernateCaching.firstlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		/*Employee emp = new Employee();
		emp.setEmpid(101);
		emp.setEname("Yasir");
		emp.setSalary(30000.700);*/
		
		Employee emp=null;
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session1 = sf.openSession();
		
		/* For raeding data from databse transaction is not required
		 * and it is costly resource don't use this for reading purpose.
		Transaction txn = session1.beginTransaction();
		session1.save(emp);
		txn.commit();*/
		
		emp = session1.load(Employee.class, 101);
		// for one fetching it fires one query
		System.out.println(emp);
		
		emp = session1.load(Employee.class, 101);
		/*If i am fetching the same object again it will not fire 
		the query again means hibernate using first level caching.
		means hibernate is not hitting the database for second time.
		*/
		System.out.println(emp);
		session1.close();
		
		
		/*first level is work for tha particular session means i am loading
		the same object as same as above it will again fire the query for 
		second session*/
		Session session2 = sf.openSession();
		emp = session2.load(Employee.class, 101);
		System.out.println(emp);
		session2.close();
		
		
	}

}
/*
Output:
Hibernate: select employee0_.empid as empid1_0_0_, employee0_.Salary as Salary2_0_0_, employee0_.ename as ename3_0_0_ from Employee employee0_ where employee0_.empid=?
Employee [empid=101, ename=Yasir, Salary=30000.7]
Employee [empid=101, ename=Yasir, Salary=30000.7]
Hibernate: select employee0_.empid as empid1_0_0_, employee0_.Salary as Salary2_0_0_, employee0_.ename as ename3_0_0_ from Employee employee0_ where employee0_.empid=?
Employee [empid=101, ename=Yasir, Salary=30000.7]
*/