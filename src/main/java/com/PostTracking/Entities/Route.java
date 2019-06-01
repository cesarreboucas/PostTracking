package com.PostTracking.Entities;

import java.sql.Timestamp;

public class Route {

    int id;
    Vehicle vehicle;
    Timestamp start;
    long wait;
    long restart;
    boolean available;
	
    public Route(int id, Vehicle vehicle, DistributionCenter origin,
                    DistributionCenter destination,
                    java.sql.Timestamp timestamp, long wait,
                    long restart, boolean available) {
        this.id = id;
        this.vehicle = vehicle;
        this.start = timestamp;
        this.wait = wait;
        this.restart = restart;
        this.available = available;
	}
}