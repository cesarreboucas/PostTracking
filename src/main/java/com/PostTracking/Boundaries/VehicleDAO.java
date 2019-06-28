package com.PostTracking.Boundaries;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Vehicle;

@Component
public interface VehicleDAO extends CrudRepository<Vehicle, Integer> {
	
	
}
