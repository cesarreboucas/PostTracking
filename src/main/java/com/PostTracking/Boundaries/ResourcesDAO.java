package com.PostTracking.Boundaries;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourcesDAO {
/*
	private SessionFactory factory = null;

	@Autowired
	public ResourcesDAO(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.factory = factory.unwrap(SessionFactory.class);
	}
	
	public SessionFactory getFactory() {
		return factory;
	}*/

}
