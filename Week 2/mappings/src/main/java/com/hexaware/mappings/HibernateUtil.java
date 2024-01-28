package com.hexaware.mappings;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionfactory;
	static {
		StandardServiceRegistry standardregistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();

		Metadata metadata = new MetadataSources(standardregistry).getMetadataBuilder().build();

		sessionfactory = metadata.getSessionFactoryBuilder().build();
	}

	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}