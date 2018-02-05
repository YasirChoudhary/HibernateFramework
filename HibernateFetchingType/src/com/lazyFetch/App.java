package com.lazyFetch;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		
		/*Student student = new Student();
		student.setRollno(1);
		student.setName("Yasir");
		
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setBrand("HP");
		laptop.setPrice(35000);
		laptop.setStudent(student);
		
		student.getLaptop().add(laptop);*/
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		/*Transaction txn = session.beginTransaction();
		session.save(student);
		session.save(laptop);
		txn.commit();*/
		
		//2 Fetching values
		//Student student = session.load(Student.class, 1);
		
		
		Student student = session.load(Student.class, 1);
		System.out.println(student.getName());
		
		/*
		 Hibernate doesn't load the values of laptop even student having
		 multiple laptops that is the type of lazy fetching
		 */
		/*Collection<Laptop> lap= student.getLaptop();
		for(Laptop l: lap) {
			System.out.println(l);
		}*/
		
		
	}
}
