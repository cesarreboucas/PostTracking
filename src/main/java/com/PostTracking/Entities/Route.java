package com.PostTracking.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;




/**
 * Represents the Journey entity
 * Associates with Vehicle and Distribution Center entities
 *
 */
@Entity
@Table(name="route")
public class Route extends Journey {
	
	public Route() {}
	
	public Route(Route r) {
		this.vehicle = r.vehicle;
        this.origin = r.origin;
        this.destination = r.destination;
        this.start = r.start;
        this.duration = r.duration;
        this.available = r.available;
        this.restart = r.restart;
	}
	
	public Route(Vehicle vehicle, DistributionCenter origin,
            DistributionCenter destination,
            Timestamp start, int duration,
            int restart, boolean available) {
		super(vehicle, origin, destination, start, duration, restart, available);
    }
}
