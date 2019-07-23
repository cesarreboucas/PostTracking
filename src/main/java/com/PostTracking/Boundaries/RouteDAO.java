package com.PostTracking.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.PostTracking.Entities.Route;


@Component
public interface RouteDAO extends CrudRepository<Route, Integer> {
    @Query("SELECT r FROM Route r WHERE (r.vehicle.available=true and r.available=true "+
        "and r.origin.available=true and r.destination.available=true)")
	Iterable<Route> findAllAvailable();
}
