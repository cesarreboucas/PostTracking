package com.PostTracking.Boundaries;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.PostTracking.Entities.Route;

/**
 * Extends CrudRepository for Route Entity
 * @author 300296145
 *
 */
@Component
public interface RouteDAO extends CrudRepository<Route, Integer> {
    @Query("SELECT r FROM Route r WHERE (r.vehicle.available=true and r.available=true " +
    "and r.origin.available=true and r.destination.available=true)")
    Iterable<Route> findAllAvailable();
    
    @Query("SELECT r FROM Route r WHERE (r.vehicle.available=true and r.available=true " +
    "and r.origin.available=true and r.destination.available=true and r.vehicle.id=:vehicleId)")
    Iterable<Route> findAllByVehicle(@Param("vehicleId") int vehicleId);

    @Query("DELETE FROM Route r WHERE (r.vehicle.available=true and r.available=true " +
    "and r.origin.available=true and r.destination.available=true and r.vehicle.id=:vehicleId)")
    @Modifying
    @Transactional
    Integer deleteRoutesByVehicle(@Param("vehicleId") int vehicleId);
}
