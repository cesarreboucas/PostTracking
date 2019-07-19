package com.PostTracking.Boundaries;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Vehicle;

@Component
public interface VehicleDAO extends CrudRepository<Vehicle, Integer> {
	@Query("SELECT v FROM Vehicle v WHERE v.deleted=false ORDER BY v.description ASC")
	Iterable<Vehicle> fetchVehicles();
	
}
