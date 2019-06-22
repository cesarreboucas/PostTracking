package com.PostTracking.Boundaries;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Journey;
import com.PostTracking.Entities.Vehicle;

@Component
public class JourneyDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Journey createJourney(Journey j) {
		entityManager.merge(j);
		return j;
	}
	
	public Journey getRoute(int id) {
		Journey j = entityManager.find(Journey.class, id);
		return j;
	}
	
	public List<Journey> getJourneys(long minimal) {
		List<Journey> routes = new ArrayList<Journey>();
		
		routes = entityManager.createQuery("from Journey where start >="+minimal, Journey.class).getResultList();
		return routes;
	}

}
