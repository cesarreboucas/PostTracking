package com.PostTracking.Entities;

import java.sql.Timestamp;

public class Route {

    protected int id;
    protected Vehicle vehicle;
    protected DistributionCenter origin;
    protected DistributionCenter destination;
    protected Timestamp start;
    protected int duration;
    protected int restart;
    protected boolean available;
	
    public Route(int id, Vehicle vehicle, DistributionCenter origin,
                    DistributionCenter destination,
                    Timestamp start, int duration,
                    int restart, boolean available) {
        this.id = id;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.start = start;
        this.duration = duration;
        this.restart = restart;
        this.available = available;
	}

	public int getId() {
		return this.id;
	}
	
	public DistributionCenter getOrigin() {
		return this.origin;
	}
	
	public DistributionCenter getDestination() {
		return this.destination;
	}
	
	public Timestamp getStart() {
		return this.start;
	}
	
	public Timestamp getArrival() {
		return new Timestamp(this.start.getTime() + this.duration);
	}
	
	public void setStart(Timestamp t) {
		this.start = t;
	}
	
	public Timestamp getNextPossible(long from) {
		//System.out.println("Now: "+from);
		//System.out.println("Start: "+this.start.getTime());
		//System.out.println("Restart: "+this.restart);
		// Number of times the route was executed till now.
		int x = (int) Math.ceil((from - this.start.getTime())/ (float)this.restart);
		Timestamp ts = new Timestamp((x*this.restart) + this.start.getTime());
		//System.out.println("Restart to next:"+x);
		//System.out.println("Next: "+ts);
		//System.out.println();
		return ts;
		
	}
    
    
}