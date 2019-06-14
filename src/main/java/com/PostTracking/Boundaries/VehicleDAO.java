package com.PostTracking.Boundaries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;


import com.PostTracking.Entities.Vehicle;

@Component
public class VehicleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int createVehicle(Vehicle v) {
		entityManager.merge(v);
		return v.getId();
	}
	
	public Vehicle getVehicle(int id) {
		Vehicle v = entityManager.find(Vehicle.class, id);
		return v;
	}
	
	public List<Vehicle> getVehicles() {
		return entityManager.createQuery("from Vehicle", Vehicle.class).getResultList();
	}
	
}
