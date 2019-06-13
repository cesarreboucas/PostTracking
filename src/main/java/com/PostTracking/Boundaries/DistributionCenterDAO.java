package com.PostTracking.Boundaries;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.PostTracking.Entities.DistributionCenter;

@Component
public class DistributionCenterDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int createDistributionCenter(DistributionCenter dc) {
		dc = entityManager.merge(dc);
		return dc.getId();
	}
}
