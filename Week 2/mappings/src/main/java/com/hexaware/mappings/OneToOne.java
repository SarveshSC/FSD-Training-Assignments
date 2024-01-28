package com.hexaware.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.mappings.entity.Address;
import com.hexaware.mappings.entity.Student;

public class OneToOne {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(session);
		
		
		//Unidirectional
//		Address address = new Address(202, "Delhi");
//		Student student = new Student(102,"Raj",address);
		
		//BiDirectional
		
		Student student = new Student(104, "Ron");
		Address address = new Address(203, "Bangalore");
		address.setStudent(student);
		
		Transaction txn = session.beginTransaction();
		
		session.persist(address);
		
		txn.commit();
		
	}
}
