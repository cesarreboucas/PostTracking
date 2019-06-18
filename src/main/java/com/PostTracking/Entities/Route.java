package com.PostTracking.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="route")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name="Route.findAll", query="SELECT a FROM Route a")
public class Route {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_vehicle")
    protected Vehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_origin")
    protected DistributionCenter origin;
    @ManyToOne(fetch = FetchType.LAZY)
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
}