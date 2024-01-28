package com.hexaware.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.mappings.entity.Department;
import com.hexaware.mappings.entity.Employee;

public class OneToMany {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		Employee e1 = new Employee(101,"King",5000.0);
		Employee e2 = new Employee(102,"Max",10000.0);
		Employee e3 = new Employee(103,"Lewis",15000.0);
		Employee e4 = new Employee(104,"George",12000.0);
		
		Department d1 = new Department();
		d1.setDeptId(201);
		d1.setDeptName("Operations");
		
		d1.addEmployee(e1);
		d1.addEmployee(e2);
		d1.addEmployee(e3);
		d1.addEmployee(e4);
		
		session.persist(d1);
		
		txn.commit();
		
	}
}
