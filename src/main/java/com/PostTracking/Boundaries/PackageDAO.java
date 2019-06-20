package com.PostTracking.Boundaries;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;



@Component
public class PackageDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int createRoute(com.PostTracking.Entities.Package p) {
		entityManager.merge(p);
		return p.getId();
	}
	
}
