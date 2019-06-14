package com.PostTracking.Entities;

import java.sql.Timestamp;

public class Journey extends Route {
	
	public Journey(Route r) {
		super(r.vehicle, r.origin, r.destination, r.start,
				r.duration, r.restart, r.available);
	}
	
	public Journey(int id, Vehicle vehicle, DistributionCenter origin,
            DistributionCenter destination,
            Timestamp start, int duration,
            int restart, boolean available) {
		super(vehicle, origin, destination, start, duration, restart, available);
	}
	
	

}
