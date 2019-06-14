package com.PostTracking.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Route")
@NamedQuery(name="Route.findAll", query="SELECT a FROM Route a")
public class Route {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
	@ManyToOne
    @JoinColumn(name="fk_vehicle")
    protected Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name="fk_origin")
    protected DistributionCenter origin;
    @ManyToOne
    @JoinColumn(name="fk_destination")
    protected DistributionCenter destination;
    protected Timestamp start;
    protected int duration;
    protected int restart;
    protected boolean available;
	
    public Route() {}
    
    public Route(Vehicle vehicle, DistributionCenter origin,
                    DistributionCenter destination,
                    Timestamp start, int duration,
                    int restart, boolean available) {
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.start = start;
        this.duration = duration;
        this.restart = restart;
        this.available = available;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public DistributionCenter getOrigin() {
		return origin;
	}

	public void setOrigin(DistributionCenter origin) {
		this.origin = origin;
	}

	public DistributionCenter getDestination() {
		return destination;
	}

	public void setDestination(DistributionCenter destination) {
		this.destination = destination;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRestart() {
		return restart;
	}

	public void setRestart(int restart) {
		this.restart = restart;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public Timestamp getStart() {
		return start;
	}

	public Timestamp getArrival() {
		return new Timestamp(this.start.getTime() + this.duration);
	}
	
	public void setStart(Timestamp t) {
		this.start = t;
	}
	
	public Timestamp getNextPossible(long from) {
		//System.out.println("Now: "+from);
		//System.out.println("Start: "+this.start);
		//System.out.println("Restart (hours): "+((double)this.restart/1000.0/60.0/60.0));
		// Number of times the route was executed till now.
		int x = (int) Math.ceil((from - this.start.getTime())/ (float)this.restart);
		//System.out.println("x: "+x+" x*res:"+(x*this.restart));
		Timestamp ts = new Timestamp((x*(long)this.restart) + this.start.getTime());
		//System.out.println("Restart to next:"+x);
		//System.out.println("Next: "+ts);
		//System.out.println();
		return ts;
		
	}
    
    
}