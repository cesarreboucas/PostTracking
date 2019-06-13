package com.PostTracking.Boundaries;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EntitiesDAOImpl {

	public static SessionFactory getFactory() {
		StandardServiceRegistry ssr = null;
		Metadata meta = null;
		SessionFactory factory = null;
		try {
			//Read the config
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			// Build the metadata from the service registry
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			//Build factory
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		return factory;
	}
}
