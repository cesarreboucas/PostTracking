package com.PostTracking.Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.PostTracking.Entities.Route;

public class VehiclePath {
    private List<Route> routes;
    private String origin, arrival;
    private Timestamp start;
    private int duration;

    public VehiclePath(List<Route> routes, String origin, String arrival, Timestamp start, int duration) {
        this.routes = new ArrayList<>(routes);
        this.origin = origin;
        this.arrival = arrival;
        this.start = start;
        this.duration = duration;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getArrival() {
        return this.arrival;
    }

    public Timestamp getStart() {
        return this.start;
    }

    public int getDuration() {
        return this.duration;
    }

}