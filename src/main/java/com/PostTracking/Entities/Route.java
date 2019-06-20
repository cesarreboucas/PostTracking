package com.PostTracking.Entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;




/**
 * Represents the Journey entity
 * Associates with Vehicle and Distribution Center entities
 *
 */
@Entity
@Table(name="route")
public class Route extends Journey {
	
	
	public Route() {}
	
	public Route(Vehicle vehicle, DistributionCenter origin,
            DistributionCenter destination,
            Timestamp start, int duration,
            int restart, boolean available) {
		super(vehicle, origin, destination, start, duration, restart, available);
	}
	

}
